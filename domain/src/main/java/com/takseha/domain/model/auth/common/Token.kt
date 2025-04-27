package com.takseha.domain.model.auth.common

data class Token(
    val accessToken: String,
    val refreshToken: String
)
