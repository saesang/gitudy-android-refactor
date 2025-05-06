package com.takseha.data.source.local.entity.mystudy

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(
    tableName = "MyStudyCategory",
    primaryKeys = ["studyId", "category"]
)
class MyStudyCategoryEntity(
    @ColumnInfo("studyId") val studyId: Int,
    @ColumnInfo("category") val category: String
)
