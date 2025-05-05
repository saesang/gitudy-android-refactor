package com.takseha.domain.usecase.study

import com.takseha.domain.repository.StudyRepository
import com.takseha.domain.utils.getOrFetch

/**
 * 스터디 북마크 여부 조회
 * : Room 먼저 조회(get) -> null이면 서버에서 조회(fetch)
 */
class GetStudyBookmarkUseCase(
    private val studyRepository: StudyRepository
) {
    suspend operator fun invoke(studyId: Int) = getOrFetch(
        get = { studyRepository.getStudyBookmark(studyId) },
        fetch = { studyRepository.fetchStudyBookmark(studyId) }
    )
}