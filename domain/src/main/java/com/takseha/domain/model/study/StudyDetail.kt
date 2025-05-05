package com.takseha.domain.model.study

data class StudyDetail(
    val id: Int,
    val studyName: String,
    val info: String,
    val cycle: StudyCycle,
    val status: StudyStatus,
    val lastCommitDay: String?,
    val studyProfileUrl: String,
    val isAppliedStudy: Boolean,
    val isLeader: Boolean,
    val githubRepoUrl: String,
    val studyCategoryList: List<String>,
    val currentMember: Int,
    val maximumMember: Int
)
