package com.takseha.domain.usecase.study

import com.takseha.domain.repository.StudyRepository
import com.takseha.domain.utils.getOrFetch

/**
 * 전체스터디 상세 정보 조회
 * : Room 먼저 조회(get) -> null이면 서버에서 조회(fetch)
 */
class GetStudyDetailUseCase(
    private val studyRepository: StudyRepository
) {
    suspend operator fun invoke(studyId: Int) = getOrFetch(
        get = { studyRepository.getStudyDetail(studyId) },
        fetch = { studyRepository.fetchStudyDetail(studyId) }
    )
}