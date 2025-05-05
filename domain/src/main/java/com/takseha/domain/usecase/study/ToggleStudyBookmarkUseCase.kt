package com.takseha.domain.usecase.study

import com.takseha.domain.repository.StudyRepository

/**
 * 스터디 북마크 추가/삭제
 */
class ToggleStudyBookmarkUseCase(
    private val studyRepository: StudyRepository
) {
    suspend operator fun invoke(studyId: Int) = studyRepository.toggleStudyBookmark(studyId)
}