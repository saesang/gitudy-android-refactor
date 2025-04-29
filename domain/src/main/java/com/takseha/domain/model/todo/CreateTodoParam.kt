package com.takseha.domain.model.todo

data class CreateTodoParam(
    val title: String,
    val detail: String,
    val deadline: String,
    val todoLink: String
)
