package com.takseha.domain.model.mystudy

import com.takseha.domain.model.study.StudyCycle
import com.takseha.domain.model.study.StudyStatus

data class MyStudyUiState(
    val id: Int,
    val studyName: String,
    val info: String,
    val cycle: StudyCycle,
    val status: StudyStatus,
    val score: Int,
    val rank: Int,
    val studyProfileUrl: String,
    val isLeader: Boolean,
    val githubRepoUrl: String,
    val studyCategoryList: List<String>,
)
