package com.takseha.domain.usecase.todo

import com.takseha.domain.model.todo.CreateTodoParam
import com.takseha.domain.repository.TodoRepository

/**
 * 투두 생성
 */
class CreateTodoUseCase(
    private val todoRepository: TodoRepository
) {
    suspend operator fun invoke(studyId: Int, createTodoParam: CreateTodoParam) = todoRepository.createTodo(studyId, createTodoParam)
}