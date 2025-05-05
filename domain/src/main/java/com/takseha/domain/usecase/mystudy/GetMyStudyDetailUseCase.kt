package com.takseha.domain.usecase.mystudy

import com.takseha.domain.repository.MyStudyRepository
import com.takseha.domain.utils.getOrFetch

/**
 * 마이스터디 상세 정보 조회
 * : Room 먼저 조회(get) -> null이면 서버에서 조회(fetch)
 */
class GetMyStudyDetailUseCase(
    private val myStudyRepository: MyStudyRepository
) {
    suspend operator fun invoke(studyId: Int) = getOrFetch(
        get = { myStudyRepository.getMyStudyDetail(studyId) },
        fetch = { myStudyRepository.fetchMyStudyDetail(studyId) }
    )
}