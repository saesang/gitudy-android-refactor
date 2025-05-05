package com.takseha.domain.model.mystudy

import com.takseha.domain.model.study.StudyCycle
import com.takseha.domain.model.study.StudyRank
import com.takseha.domain.model.study.StudyStatus

data class MyStudyDetail(
    val id: Int,
    val studyName: String,
    val info: String,
    val cycle: StudyCycle,
    val status: StudyStatus,
    val rankAndScore: StudyRank,
    val studyProfileUrl: String,
    val isLeader: Boolean,
    val githubRepoUrl: String,
    val studyCategoryList: List<String>,
)
