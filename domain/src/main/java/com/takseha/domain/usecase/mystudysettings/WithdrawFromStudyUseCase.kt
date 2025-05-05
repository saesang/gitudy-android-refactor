package com.takseha.domain.usecase.mystudysettings

import com.takseha.domain.repository.MyStudyRepository

/**
 * 스터디 탈퇴
 */
class WithdrawFromStudyUseCase(
    private val myStudyRepository: MyStudyRepository
) {
    suspend operator fun invoke(studyId: Int) = myStudyRepository.withdrawFromStudy(studyId)
}