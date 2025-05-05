package com.takseha.data.source.remote.dto.todo.request

import com.google.gson.annotations.SerializedName

data class TodoCreateRequest(
    @SerializedName("detail")
    val detail: String,
    @SerializedName("title")
    val title: String,
    @SerializedName("todo_date")
    val todoDate: String,
    @SerializedName("todo_link")
    val todoLink: String
)