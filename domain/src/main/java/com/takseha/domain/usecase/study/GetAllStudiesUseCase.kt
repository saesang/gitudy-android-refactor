package com.takseha.domain.usecase.study

import com.takseha.domain.model.study.StudiesInfo
import com.takseha.domain.model.study.StudyItem
import com.takseha.domain.model.study.StudySortType
import com.takseha.domain.repository.StudyRepository
import com.takseha.domain.utils.getOrFetch
import kotlinx.coroutines.async
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.coroutineScope

/**
 * 전체스터디 메뉴 화면 정보 조회
 * : Room 먼저 조회(get) -> null이면 서버에서 조회(fetch)
 */
class GetAllStudiesUseCase(
    private val studyRepository: StudyRepository
) {
    suspend operator fun invoke(
        cursorIdx: Long?,
        limit: Long = 10,
        sortBy: String = StudySortType.SCORE.value
    ) = coroutineScope {
        val totalStudyCountDeferred = async {
            getOrFetch(
                get = { studyRepository.getTotalStudyCount() },
                fetch = { studyRepository.fetchTotalStudyCount() }
            )
        }
        val allStudiesDeferred = async {
            buildAllStudyItems(cursorIdx, limit, sortBy)
        }

        StudiesInfo(
            count = totalStudyCountDeferred.await(),
            items = allStudiesDeferred.await()
        )
    }

    private suspend fun buildAllStudyItems(
        cursorIdx: Long?,
        limit: Long,
        sortBy: String
    ): List<StudyItem> = coroutineScope {
        val allStudySummaries = getOrFetch(
            get = { studyRepository.getAllStudySummaries(cursorIdx, limit, sortBy) },
            fetch = { studyRepository.fetchAllStudySummaries(cursorIdx, limit, sortBy) }
        )

        val studyItemsDeferred = allStudySummaries.map { summary ->
            async {
                val rankAndScoreDeferred =
                    async { studyRepository.fetchStudyRankAndScore(summary.id) }
                val isBookmarkedDeferred =
                    async {
                        getOrFetch(
                            get = { studyRepository.getStudyBookmark(summary.id) },
                            fetch = { studyRepository.fetchStudyBookmark(summary.id) }
                        )
                    }

                StudyItem(
                    studySummary = summary,
                    rankAndScore = rankAndScoreDeferred.await(),
                    isBookmarked = isBookmarkedDeferred.await()
                )
            }
        }

        studyItemsDeferred.awaitAll()
    }
}