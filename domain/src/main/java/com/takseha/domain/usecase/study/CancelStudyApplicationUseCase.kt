package com.takseha.domain.usecase.study

import com.takseha.domain.repository.StudyRepository

/**
 * 스터디 신청 취소
 */
class CancelStudyApplicationUseCase(
    private val studyRepository: StudyRepository
) {
    suspend operator fun invoke(studyId: Int) =
        studyRepository.cancelStudyApplication(studyId)
}