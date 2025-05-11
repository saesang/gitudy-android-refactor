package com.takseha.data.source.local.entity.mystudy

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "MyStudyDetail")
class MyStudyDetailWithoutCategoryEntity(
    @PrimaryKey val id: Int,
    @ColumnInfo("studyName") val studyName: String,
    @ColumnInfo("info") val info: String,
    @ColumnInfo("cycle") val cycle: String,
    @ColumnInfo("status") val status: String,
    @ColumnInfo("studyProfileUrl") val studyProfileUrl: String,
    @ColumnInfo("isLeader") val isLeader: Boolean,
    @ColumnInfo("githubRepoUrl") val githubRepoUrl: String
)
