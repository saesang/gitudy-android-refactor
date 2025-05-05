package com.takseha.domain.usecase.study

import com.takseha.domain.repository.StudyRepository

/**
 * 전체스터디 랭킹/점수 정보 조회
 */
class GetStudyRankAndScoreUseCase(
    private val studyRepository: StudyRepository
) {
    suspend operator fun invoke(studyId: Int) = studyRepository.fetchStudyRankAndScore(studyId)
}