package com.takseha.data.source.local.entity.mystudy

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "MyStudyMember",
    primaryKeys = ["studyId", "userName"]
)
class MyStudyMemberEntity(
    @ColumnInfo("studyId") val studyId: Int,
    @ColumnInfo("userName") val userName: String,
    @ColumnInfo("profileUrl") val profileUrl: String,
    @ColumnInfo("point") val point: Int
)
