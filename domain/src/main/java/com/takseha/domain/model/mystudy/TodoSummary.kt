package com.takseha.domain.model.mystudy

data class TodoSummary(
    val id: Int,
    val studyId: Int,
    val title: String,
    val deadline: String,
    val completeMemberCount: Int,
    val totalMemberCount: Int,
    val myStatus: TodoStatus
)
