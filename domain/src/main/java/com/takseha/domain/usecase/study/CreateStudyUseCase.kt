package com.takseha.domain.usecase.study

import com.takseha.domain.model.study.CreateStudyParam
import com.takseha.domain.repository.StudyRepository

/**
 * 스터디 생성
 */
class CreateStudyUseCase(
    private val studyRepository: StudyRepository
) {
    suspend operator fun invoke(createStudyParam: CreateStudyParam) = studyRepository.createStudy(createStudyParam)
}