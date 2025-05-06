package com.takseha.domain.model.auth

import com.takseha.domain.model.auth.common.Role
import com.takseha.domain.model.auth.common.Token

data class TokenInfo(
    val tokens: Token,
    val role: Role?
)