package com.takseha.domain.usecase.mystudy

import com.takseha.domain.model.mystudy.MyStudiesInfo
import com.takseha.domain.model.mystudy.MyStudyItem
import com.takseha.domain.model.study.StudySortType
import com.takseha.domain.repository.MyStudyRepository
import com.takseha.domain.utils.getOrFetch
import kotlinx.coroutines.async
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.coroutineScope

/**
 * 마이스터디 메뉴 화면 정보 조회
 * : Room 먼저 조회(get) -> null이면 서버에서 조회(fetch)
 */
class GetMyStudiesUseCase(
    private val myStudyRepository: MyStudyRepository
) {
    suspend operator fun invoke(
        cursorIdx: Long?,
        limit: Long = 10,
        sortBy: String = StudySortType.SCORE.value
    ) = coroutineScope {
        val myStudyCountDeferred = async {
            getOrFetch(
                get = { myStudyRepository.getMyStudyCount() },
                fetch = { myStudyRepository.fetchMyStudyCount() }
            )
        }
        val myStudiesDeferred = async {
            buildMyStudyItems(cursorIdx, limit, sortBy)
        }

        MyStudiesInfo(
            count = myStudyCountDeferred.await(),
            items = myStudiesDeferred.await()
        )
    }

    private suspend fun buildMyStudyItems(
        cursorIdx: Long?,
        limit: Long,
        sortBy: String
    ): List<MyStudyItem> = coroutineScope {
        val myStudySummaries = getOrFetch(
            get = { myStudyRepository.getMyStudySummaries(cursorIdx, limit, sortBy) },
            fetch = { myStudyRepository.fetchMyStudySummaries(cursorIdx, limit, sortBy) }
        )
        val myStudyItemsDeferred = myStudySummaries.map { summary ->
            async {
                val nearestDeadlineTodo = getOrFetch(
                    get = { myStudyRepository.getNearestDeadlineTodoInfo(summary.id) },
                    fetch = { myStudyRepository.fetchNearestDeadlineTodoInfo(summary.id) }
                )

                MyStudyItem(
                    myStudySummary = summary,
                    nearestDeadlineTodoInfo = nearestDeadlineTodo
                )
            }
        }

        myStudyItemsDeferred.awaitAll()
    }
}