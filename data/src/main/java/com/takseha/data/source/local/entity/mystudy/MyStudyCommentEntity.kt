package com.takseha.data.source.local.entity.mystudy

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "MyStudyComment")
data class MyStudyCommentEntity (
    @PrimaryKey val id: Int,
    @ColumnInfo("studyId") val studyId: Int,
    @ColumnInfo("writerName") val writerName: String,
    @ColumnInfo("writerProfileUrl") val writerProfileUrl: String,
    @ColumnInfo("content") val content: String,
    @ColumnInfo("createdAt") val createdAt: String,
    @ColumnInfo("isMyComment") val isMyComment: Boolean
)