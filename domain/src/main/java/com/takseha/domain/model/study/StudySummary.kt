package com.takseha.domain.model.study

data class StudySummary(
    val id: Int,
    val studyName: String,
    val daysSinceStart: Int,
    val cycle: StudyCycle,
    val status: StudyStatus,
    val score: Int,
    val lastCommitDay: String?,
    val studyProfileUrl: String,
    val studyCategoryList: List<String>,
    val currentMember: Int,
    val maximumMember: Int,
    val studyMemberProfileUrlList: List<String>
)