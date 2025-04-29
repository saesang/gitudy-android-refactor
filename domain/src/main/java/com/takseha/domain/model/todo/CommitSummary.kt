package com.takseha.domain.model.todo

data class CommitSummary(
    val id: Int,
    val studyInfoId: Int,
    val todoId: Int,
    val createdAt: String,
    val message: String?,
    val status: CommitStatus,
    val creatorName: String,
    val creatorProfileUrl: String?
)
