package com.takseha.data.source.local.entity.mystudy

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "MyStudyCount")
class MyStudyCountEntity(
    @PrimaryKey val id: Int = 0,
    @ColumnInfo("count") val count: Int
)
