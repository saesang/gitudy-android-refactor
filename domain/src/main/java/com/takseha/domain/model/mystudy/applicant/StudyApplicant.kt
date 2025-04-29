package com.takseha.domain.model.mystudy.applicant

data class StudyApplicant(
    val id: Int,
    val name: String,
    val githubId: String,
    val profileUrl: String,
    val profilePublicYn: Boolean,
    val signGreeting: String,
    val appliedAt: String,
    val socialInfo: SocialInfo?
)

