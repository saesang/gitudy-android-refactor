package com.takseha.domain.model.study

data class CreateStudyParam(
    val topic: String,
    val info: String,
    val repositoryName: String,
    val categoryIds: List<Int>,
    val status: StudyStatus,
    val cycle: StudyCycle,
    val maximumMember: Int,
    val profileUrl: String
)