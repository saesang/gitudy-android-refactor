package com.takseha.domain.model.mystudy

data class TodoSummary(
    val id: Int,
    val studyInfoId: Int,
    val title: String,
    val deadline: String,
    val completeMemberCount: Int,
    val totalMemberCount: Int,
    val myStatus: TodoStatus
)
