package com.takseha.domain.model.auth

data class SignUpParam (
    val name: String,
    val fcmToken: String,
    val pushAlarmYn: Boolean
)