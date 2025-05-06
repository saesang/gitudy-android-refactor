package com.takseha.data.source.local.entity.study

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "StudyRank")
class StudyRankEntity(
    @PrimaryKey val studyId: Int,
    @ColumnInfo("rank") val rank: Int,
    @ColumnInfo("score") val score: Int
)
