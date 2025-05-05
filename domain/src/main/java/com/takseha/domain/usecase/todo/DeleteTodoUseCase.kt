package com.takseha.domain.usecase.todo

import com.takseha.domain.repository.TodoRepository

/**
 * 투두 삭제
 */
class DeleteTodoUseCase(
    private val todoRepository: TodoRepository
) {
    suspend operator fun invoke(studyId: Int, todoId: Int) = todoRepository.deleteTodo(studyId, todoId)
}