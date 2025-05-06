package com.takseha.data.source.local.entity.mystudy

import androidx.room.Entity

@Entity(tableName = "MyStudyComment")
data class MyStudyCommentEntity (
    val id: Int,
    val studyId: Int,
    val writerName: String,
    val writerProfileUrl: String,
    val content: String,
    val createdAt: String,
    val isMyComment: Boolean
)