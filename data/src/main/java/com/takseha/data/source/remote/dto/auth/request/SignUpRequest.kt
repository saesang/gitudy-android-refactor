package com.takseha.data.source.remote.dto.auth.request

import com.google.gson.annotations.SerializedName

data class SignUpRequest(
    @SerializedName("name")
    val name: String,
    @SerializedName("fcm_token")
    val fcmToken: String,
    @SerializedName("push_alarm_yn")
    val pushAlarmYn: Boolean
)