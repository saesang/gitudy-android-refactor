package com.takseha.domain.model.profile

data class UpdateUserInfoParam(
    val name: String,
    val profileImageUrl: String,
    val socialInfo: SocialInfo?,
    val profilePublicYn: Boolean,
)
