package com.takseha.domain.model.mystudy

data class MyStudySummary(
    val id: Int,
    val studyName: String,
    val score: Int,
    val rank: Int,
    val studyProfileUrl: String,
    val isLeader: Boolean,
    val nearestDeadlineTodoInfo: TodoSummary?
)
