package com.takseha.domain.usecase.mystudy

import com.takseha.domain.repository.MyStudyRepository
import com.takseha.domain.utils.getOrFetch

/**
 * 마이스터디 랭킹/점수 정보 조회
 */
class GetNearestDeadlineTodoUseCase(
    private val myStudyRepository: MyStudyRepository
) {
    suspend operator fun invoke(studyId: Int) = getOrFetch(
        get = { myStudyRepository.getNearestDeadlineTodoInfo(studyId) },
        fetch = { myStudyRepository.fetchNearestDeadlineTodoInfo(studyId) }
    )
}