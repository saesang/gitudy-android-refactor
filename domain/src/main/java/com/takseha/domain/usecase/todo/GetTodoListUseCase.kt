package com.takseha.domain.usecase.todo

import com.takseha.domain.repository.TodoRepository
import com.takseha.domain.utils.getOrFetch

/**
 * 투두 리스트 조회
 * : Room 먼저 조회(get) -> null이면 서버에서 조회(fetch)
 */
class GetTodoListUseCase(
    private val todoRepository: TodoRepository
) {
    suspend operator fun invoke(cursorIdx: Long? = null, limit: Long = 10, studyId: Int) = getOrFetch(
        get = { todoRepository.getTodoList(cursorIdx, limit, studyId) },
        fetch = { todoRepository.fetchTodoList(cursorIdx, limit, studyId) }
    )
}