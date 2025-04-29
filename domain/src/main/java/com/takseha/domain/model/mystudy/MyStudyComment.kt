package com.takseha.domain.model.mystudy

data class MyStudyComment (
    val id: Int,
    val studyId: Int,
    val writerName: String,
    val writerProfileUrl: String,
    val content: String,
    val createdAt: String,
    val isMyComment: Boolean
)