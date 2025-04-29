package com.takseha.domain.model.todo

data class TodoDetail(
    val id: Int,
    val studyInfoId: Int,
    val title: String,
    val deadline: String,
    val todoLink: String,
    val createdAt: String,
    val commitList: List<CommitSummary>
)