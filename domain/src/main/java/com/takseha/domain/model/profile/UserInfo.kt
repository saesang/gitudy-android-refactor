package com.takseha.domain.model.profile

import com.takseha.domain.model.auth.common.Role

data class UserInfo(
    val name: String,
    val githubId: String,
    val score: Int,
    val point: Int,
    val role: Role,
    val rank: Int,
    val profileImageUrl: String,
    val profilePublicYn: Boolean,
    val pushAlarmYn: Boolean
)
