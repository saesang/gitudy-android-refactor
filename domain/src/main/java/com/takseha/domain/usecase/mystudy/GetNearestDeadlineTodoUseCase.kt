package com.takseha.domain.usecase.mystudy

import com.takseha.domain.repository.MyStudyRepository
import com.takseha.domain.utils.getOrFetch

/**
 * 마감일 임박 투두 정보 조회
 * : Room 먼저 조회(get) -> null이면 서버에서 조회(fetch)
 */
class GetNearestDeadlineTodoUseCase(
    private val myStudyRepository: MyStudyRepository
) {
    suspend operator fun invoke(studyId: Int) = getOrFetch(
        get = { myStudyRepository.getNearestDeadlineTodoInfo(studyId) },
        fetch = { myStudyRepository.fetchNearestDeadlineTodoInfo(studyId) }
    )
}