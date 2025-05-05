package com.takseha.data.source.remote.dto.auth.response


import com.google.gson.annotations.SerializedName

data class SignInPageInfoResponse(
    @SerializedName("platform_type")
    val platformType: String,
    @SerializedName("url")
    val url: String
)