package com.takseha.domain.usecase.mystudy

import com.takseha.domain.repository.MyStudyRepository

/**
 * 마이스터디 랭킹/점수 정보 조회
 */
class GetMyStudyRankAndScoreUseCase(
    private val myStudyRepository: MyStudyRepository
) {
    suspend operator fun invoke(studyId: Int) = myStudyRepository.fetchStudyRankAndScore(studyId)
}