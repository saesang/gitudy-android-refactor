package com.takseha.data.source.local.entity.notification

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Notification")
class NotificationEntity(
    @PrimaryKey val id: String,
    @ColumnInfo("studyId") val studyId: Int,
    @ColumnInfo("createdAt") val createdAt: String,
    @ColumnInfo("title") val title: String,
    @ColumnInfo("message") val message: String
)
