package com.takseha.data.source.local.entity.mystudy

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "MyStudyCategory")
class MyStudyCategoryEntity(
    @PrimaryKey val studyId: Int,
    @ColumnInfo("category") val category: String
)
