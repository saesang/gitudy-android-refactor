package com.takseha.domain.model.study

data class Study(
    val id: Int,
    val createdDateTime: String,
    val topic: String,
    val info: String,
    val cycle: StudyCycle,
    val status: StudyStatus,
    val score: Int,
    val rank: Int,
    val lastCommitDay: String?,
    val studyProfileUrl: String,
    val isLeader: Boolean,
    val studyCategoryList: List<String>,
    val currentMember: Int,
    val maximumMember: Int,
    val studyMemberProfileUrlList: List<String>
)
