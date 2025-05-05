package com.takseha.domain.usecase.mystudysettings

import com.takseha.domain.repository.MyStudyRepository

/**
 * 스터디 신청 승인/거절
 */
class RespondToStudyApplicationUseCase(
    private val myStudyRepository: MyStudyRepository
) {
    suspend operator fun invoke(studyId: Int, applicantId: Int, isAccepted: Boolean) =
        myStudyRepository.respondToStudyApplication(studyId, applicantId, isAccepted)
}