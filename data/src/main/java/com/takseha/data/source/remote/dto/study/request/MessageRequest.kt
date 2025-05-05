package com.takseha.data.source.remote.dto.study.request


import com.google.gson.annotations.SerializedName

data class MessageRequest(
    @SerializedName("message")
    val message: String
)