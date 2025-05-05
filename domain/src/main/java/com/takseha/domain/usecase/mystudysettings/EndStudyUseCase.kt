package com.takseha.domain.usecase.mystudysettings

import com.takseha.domain.repository.MyStudyRepository

/**
 * 스터디 종료
 */
class EndStudyUseCase(
    private val myStudyRepository: MyStudyRepository
) {
    suspend operator fun invoke(studyId: Int) = myStudyRepository.endStudy(studyId)
}