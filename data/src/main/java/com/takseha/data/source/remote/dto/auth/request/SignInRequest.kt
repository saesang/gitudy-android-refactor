package com.takseha.data.source.remote.dto.auth.request

data class SignInRequest(
    val code: String,
    val state: String
)