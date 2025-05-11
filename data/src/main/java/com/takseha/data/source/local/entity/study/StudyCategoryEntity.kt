package com.takseha.data.source.local.entity.study

import androidx.room.ColumnInfo
import androidx.room.Entity

@Entity(
    tableName = "StudyCategory",
    primaryKeys = ["studyId", "category"]
)
class StudyCategoryEntity(
    @ColumnInfo("studyId") val studyId: Int,
    @ColumnInfo("category") val category: String
)
