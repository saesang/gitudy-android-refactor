package com.takseha.data.source.local.entity.mystudy

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.takseha.domain.model.mystudy.TodoStatus

@Entity(tableName = "TodoSummary")
class TodoSummaryEntity(
    @PrimaryKey val id: Int,
    @ColumnInfo("studyId") val studyId: Int,
    @ColumnInfo("title") val title: String,
    @ColumnInfo("deadline") val deadline: String,
    @ColumnInfo("completeMemberCount") val completeMemberCount: Int,
    @ColumnInfo("totalMemberCount") val totalMemberCount: Int,
    @ColumnInfo("myStatus") val myStatus: String
)
