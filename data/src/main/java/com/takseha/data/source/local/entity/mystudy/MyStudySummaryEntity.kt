package com.takseha.data.source.local.entity.mystudy

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "MyStudySummary")
class MyStudySummaryEntity(
    @PrimaryKey val id: Int,
    @ColumnInfo("studyName") val studyName: String,
    @ColumnInfo("score") val score: Int,
    @ColumnInfo("studyProfileUrl") val studyProfileUrl: String,
    @ColumnInfo("isLeader") val isLeader: Boolean
)
