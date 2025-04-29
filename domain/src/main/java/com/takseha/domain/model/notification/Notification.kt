package com.takseha.domain.model.notification

data class Notification(
    val id: String,
    val studyInfoId: Int,
    val createdAt: String,
    val message: String,
    val title: String
)
