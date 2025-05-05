package com.takseha.domain.repository

import com.takseha.domain.model.todo.CreateTodoParam
import com.takseha.domain.model.todo.TodoDetail

interface TodoRepository {
    /** 투두 리스트 조회 */
    suspend fun getTodoList(cursorIdx: Long?, limit: Long, studyId: Int): List<TodoDetail>?
    suspend fun fetchTodoList(cursorIdx: Long?, limit: Long, studyId: Int): List<TodoDetail>

    /** 투두 상세 정보 조회 */
    suspend fun getTodoDetail(studyId: Int, todoId: Int): TodoDetail?
    suspend fun fetchTodoDetail(studyId: Int, todoId: Int): TodoDetail

    /** 투두 등록 */
    suspend fun createTodo(studyId: Int, createTodoParam: CreateTodoParam)

    /** 투두 수정 */
    suspend fun updateTodo(studyId: Int, todoId: Int, createTodoParam: CreateTodoParam)

    /** 투두 삭제 */
    suspend fun deleteTodo(studyId: Int, todoId: Int)
}