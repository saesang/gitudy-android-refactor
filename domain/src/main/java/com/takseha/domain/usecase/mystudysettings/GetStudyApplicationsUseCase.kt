package com.takseha.domain.usecase.mystudysettings

import com.takseha.domain.repository.MyStudyRepository
import com.takseha.domain.utils.getOrFetch

/**
 * 스터디 신청자 리스트 조회
 * : Room 먼저 조회(get) -> null이면 서버에서 조회(fetch)
 */
class GetStudyApplicationsUseCase(
    private val myStudyRepository: MyStudyRepository
) {
    suspend operator fun invoke(cursorIdx: Long? = null, limit: Long = 10, studyId: Int) = getOrFetch(
        get = { myStudyRepository.getStudyApplications(cursorIdx, limit, studyId) },
        fetch = { myStudyRepository.fetchStudyApplications(cursorIdx, limit, studyId) }
    )
}