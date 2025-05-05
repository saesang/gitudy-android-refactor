package com.takseha.domain.model.mystudy

data class MyStudySummary(
    val id: Int,
    val studyName: String,
    val score: Int,
    val studyProfileUrl: String,
    val isLeader: Boolean
)
