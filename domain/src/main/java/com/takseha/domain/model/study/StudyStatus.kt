package com.takseha.domain.model.study

enum class StudyStatus {
    STUDY_PUBLIC, STUDY_PRIVATE, STUDY_DELETED, STUDY_INACTIVE;

    companion object {
        fun from(value: String): StudyStatus =
            StudyStatus.entries.find { it.name.equals(value, ignoreCase = true) }
                ?: STUDY_PUBLIC // 기본값
    }
}