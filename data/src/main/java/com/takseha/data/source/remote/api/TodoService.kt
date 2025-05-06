package com.takseha.data.source.remote.api

import com.takseha.data.source.remote.dto.todo.request.TodoCreateRequest
import com.takseha.data.source.remote.dto.todo.response.TodoListResponse
import com.takseha.data.source.remote.dto.todo.response.TodoResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path
import retrofit2.http.Query

/**
 * 투두 관련 api 정의 인터페이스
 */
interface TodoService {
    @GET("/study/{studyInfoId}/todo")
    suspend fun fetchTodoList(
        @Path("studyInfoId") studyId: Int,
        @Query("cursorIdx") cursorIdx: Long?,
        @Query("limit") limit: Long,
    ): Response<TodoListResponse>

    @GET("/study/{studyInfoId}/todo/{todoId}")
    suspend fun fetchTodoDetail(
        @Path("studyInfoId") studyId: Int,
        @Path("todoId") todoId: Int,
    ): Response<TodoResponse>

    @POST("/study/{studyInfoId}/todo")
    suspend fun createTodo(
        @Path("studyInfoId") studyId: Int,
        @Body request: TodoCreateRequest
    ): Response<Void>

    @PUT("/study/{studyInfoId}/todo/{todoId}")
    suspend fun updateTodo(
        @Path("studyInfoId") studyId: Int,
        @Path("todoId") todoId: Int,
        @Body request: TodoCreateRequest
    ): Response<Void>

    @DELETE("/study/{studyInfoId}/todo/{todoId}")
    suspend fun deleteTodo(
        @Path("studyInfoId") studyId: Int,
        @Path("todoId") todoId: Int
    ): Response<Void>
}