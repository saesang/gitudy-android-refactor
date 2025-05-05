package com.takseha.domain.usecase.study

import com.takseha.domain.repository.StudyRepository

/**
 * 깃허브 레포지토리 이름 중복 여부 확인
 */
class CheckRepoNameDuplicationUseCase(
    private val studyRepository: StudyRepository
) {
    suspend operator fun invoke(repoName: String) = studyRepository.checkRepoNameDuplication(repoName)
}