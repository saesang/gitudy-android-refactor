package com.takseha.data.source.remote.dto.auth.response


import com.google.gson.annotations.SerializedName
import com.takseha.domain.model.auth.common.Role

data class TokenInfoResponse(
    @SerializedName("access_token")
    val accessToken: String,
    @SerializedName("refresh_token")
    val refreshToken: String,
    @SerializedName("role")
    val role: Role?
)