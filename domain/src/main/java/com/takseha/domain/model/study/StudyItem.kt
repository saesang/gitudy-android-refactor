package com.takseha.domain.model.study

data class StudyItem(
    val studySummary: StudySummary,
    val rankAndScore: StudyRank,
    val isBookmarked: Boolean
)
