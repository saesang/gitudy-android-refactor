package com.takseha.domain.usecase.study

import com.takseha.domain.repository.StudyRepository

/**
 * 스터디 신청
 */
class SubmitStudyApplicationUseCase(
    private val studyRepository: StudyRepository
) {
    suspend operator fun invoke(studyId: Int, joinReason: String) =
        studyRepository.submitStudyApplication(studyId, joinReason)
}