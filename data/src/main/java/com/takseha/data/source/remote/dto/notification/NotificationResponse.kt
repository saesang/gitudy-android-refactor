package com.takseha.data.source.remote.dto.notification


import com.google.gson.annotations.SerializedName

data class NotificationResponse(
    @SerializedName("id")
    val id: String,
    @SerializedName("local_date_time")
    val localDateTime: String,
    @SerializedName("message")
    val message: String,
    @SerializedName("study_info_id")
    val studyInfoId: Int,
    @SerializedName("title")
    val title: String
)