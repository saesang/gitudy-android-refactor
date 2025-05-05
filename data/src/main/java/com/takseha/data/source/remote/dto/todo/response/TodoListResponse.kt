package com.takseha.data.source.remote.dto.todo.response


import com.google.gson.annotations.SerializedName

data class TodoListResponse(
    @SerializedName("todo_list")
    val todoList: List<TodoResponse>,
    @SerializedName("cursor_idx")
    val cursorIdx: Int
)