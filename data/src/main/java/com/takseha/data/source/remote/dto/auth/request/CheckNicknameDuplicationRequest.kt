package com.takseha.data.source.remote.dto.auth.request


import com.google.gson.annotations.SerializedName

data class CheckNicknameDuplicationRequest(
    @SerializedName("name")
    val nickname: String
)