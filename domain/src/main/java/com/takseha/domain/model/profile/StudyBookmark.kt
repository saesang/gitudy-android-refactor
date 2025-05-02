package com.takseha.domain.model.profile

import com.takseha.domain.model.study.StudySummary

data class StudyBookmark(
    val id: Int,
    val studyId: Int,
    val studySummary: StudySummary
)