package com.takseha.domain.model.study

enum class StudyCycle {
    STUDY_PERIOD_EVERYDAY, STUDY_PERIOD_WEEK, STUDY_PERIOD_NONE;

    companion object {
        fun from(value: String): StudyCycle =
            entries.find { it.name.equals(value, ignoreCase = true) }
                ?: STUDY_PERIOD_WEEK // 기본값
    }
}