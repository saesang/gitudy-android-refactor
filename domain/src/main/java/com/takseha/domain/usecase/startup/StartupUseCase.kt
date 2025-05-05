package com.takseha.domain.usecase.startup

import com.takseha.domain.model.common.StartupInfo
import com.takseha.domain.model.mystudy.MyStudiesInfo
import com.takseha.domain.model.mystudy.MyStudyItem
import com.takseha.domain.model.study.StudiesInfo
import com.takseha.domain.model.study.StudyItem
import com.takseha.domain.model.study.StudySortType
import com.takseha.domain.repository.MyStudyRepository
import com.takseha.domain.repository.NotificationRepository
import com.takseha.domain.repository.ProfileRepository
import com.takseha.domain.repository.StudyRepository
import kotlinx.coroutines.async
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.supervisorScope

/**
 * 홈화면 첫 진입 시, 서버 데이터와 앱 내부 저장 데이터 동기화
 */
class StartupUseCase(
    private val profileRepository: ProfileRepository,
    private val notificationRepository: NotificationRepository,
    private val myStudyRepository: MyStudyRepository,
    private val studyRepository: StudyRepository,
) {
    suspend operator fun invoke() = supervisorScope {
        val userInfoDeferred = async {
            runCatching {
                profileRepository.fetchUserInfo()
            }.getOrNull()
        }
        val notificationsDeferred = async {
            runCatching {
                notificationRepository.fetchNotifications(
                    cursorTime = null,
                    limit = 20
                )
            }.getOrNull()
        }
        val myStudyCountDeferred = async {
            runCatching { myStudyRepository.fetchMyStudyCount() }.getOrNull()
        }
        val myStudiesDeferred = async {
            runCatching { buildMyStudyItems() }.getOrNull()
        }

        val totalStudyCountDeferred = async {
            runCatching { studyRepository.fetchTotalStudyCount() }.getOrNull()
        }
        val allStudiesDeferred = async {
            runCatching { buildAllStudyItems() }.getOrNull()
        }

        val myCommitsDeferred = async {
            runCatching {
                profileRepository.fetchMyCommits(
                    cursorIdx = null,
                    limit = 3,
                    studyId = null
                )
            }.getOrNull()
        }

        val studyBookmarksDeferred = async {
            runCatching {
                profileRepository.fetchStudyBookmarks(
                    cursorIdx = null,
                    limit = 3
                )
            }.getOrNull()
        }

        StartupInfo(
            userInfo = userInfoDeferred.await(),
            notifications = notificationsDeferred.await(),
            myStudiesInfo = buildStudiesInfo(
                count = myStudyCountDeferred.await(),
                items = myStudiesDeferred.await()
            ) { count, items ->
                MyStudiesInfo(count, items)
            },
            allStudiesInfo = buildStudiesInfo(
                count = totalStudyCountDeferred.await(),
                items = allStudiesDeferred.await()
            ) { count, items ->
                StudiesInfo(count, items)
            },
            myCommits = myCommitsDeferred.await(),
            studyBookmarks = studyBookmarksDeferred.await()
        )
    }

    private fun <T, R> buildStudiesInfo(
        count: Int?,
        items: List<T>?,
        build: (count: Int, items: List<T>) -> R
    ): R? {
        return if (count != null && items != null) {
            build(count, items)
        } else null
    }

    /** 마이스터디 목록 조회
     * : 마이스터디 summary 리스트 조회 -> 스터디 별 마감일 임박 투두 정보 조회(병렬)
     * -> summary와 투두 정보를 합쳐서 MyStudyItem 리스트 생성 후 리턴
     */
    private suspend fun buildMyStudyItems(): List<MyStudyItem> = coroutineScope {
        val myStudySummaries = myStudyRepository.fetchMyStudySummaries(
            cursorIdx = null,
            limit = 10,
            sortBy = StudySortType.SCORE.value
        )
        val myStudyItemsDeferred = myStudySummaries.map { summary ->
            async {
                val nearestDeadlineTodo = myStudyRepository.fetchNearestDeadlineTodoInfo(summary.id)
                MyStudyItem(
                    myStudySummary = summary,
                    nearestDeadlineTodoInfo = nearestDeadlineTodo
                )
            }
        }

        myStudyItemsDeferred.awaitAll()
    }

    /** 전체스터디 목록 조회
     * : 전체스터디 summary 리스트 조회 -> 스터디 별 랭킹 조회(병렬) | 스터디 별 북마크 여부 조회(병렬)
     * -> summary와 랭킹, 북마크 여부 정보를 합쳐서 StudyItem 리스트 생성 후 리턴
     */
    private suspend fun buildAllStudyItems(): List<StudyItem> = coroutineScope {
        val allStudySummaries = studyRepository.fetchAllStudySummaries(
            cursorIdx = null,
            limit = 10,
            sortBy = StudySortType.SCORE.value
        )
        val studyItemsDeferred = allStudySummaries.map { summary ->
            async {
                val rankDeferred = async { studyRepository.fetchStudyRank(summary.id) }
                val isBookmarkedDeferred =
                    async { studyRepository.fetchStudyBookmark(summary.id) }

                StudyItem(
                    studySummary = summary,
                    rank = rankDeferred.await(),
                    isBookmarked = isBookmarkedDeferred.await()
                )
            }
        }

        studyItemsDeferred.awaitAll()
    }
}