package com.takseha.domain.usecase.home

import com.takseha.domain.model.mystudy.MyStudyItem
import com.takseha.domain.model.study.StudySortType
import com.takseha.domain.repository.MyStudyRepository
import com.takseha.domain.utils.getOrFetch
import kotlinx.coroutines.async
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.coroutineScope

/**
 * 마감일 임박 투두 리스트 조회
 * : Room 먼저 조회(get) -> null이면 서버에서 조회(fetch)
 */
class GetHomeTodoListUseCase(
    private val myStudyRepository: MyStudyRepository
) {
    suspend operator fun invoke(
        cursorIdx: Long?,
        limit: Long = 10,
        sortBy: String = StudySortType.SCORE.value
    ) = buildHomeTodoList(cursorIdx, limit, sortBy)

    private suspend fun buildHomeTodoList(
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

                if (nearestDeadlineTodo != null) {
                    MyStudyItem(
                        myStudySummary = summary,
                        nearestDeadlineTodoInfo = nearestDeadlineTodo
                    )
                } else null
            }
        }

        myStudyItemsDeferred.awaitAll().filterNotNull()
    }
}