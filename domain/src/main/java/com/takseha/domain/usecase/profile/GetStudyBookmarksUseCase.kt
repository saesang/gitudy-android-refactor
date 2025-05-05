package com.takseha.domain.usecase.profile

import com.takseha.domain.repository.ProfileRepository
import com.takseha.domain.utils.getOrFetch

/**
 * 스터디 북마크 리스트 조회
 * : Room 먼저 조회(get) -> null이면 서버에서 조회(fetch)
 */
class GetStudyBookmarksUseCase(
    private val profileRepository: ProfileRepository
) {
    suspend operator fun invoke(cursorIdx: Long? = null, limit: Long = 3) =
        getOrFetch(
            get = { profileRepository.getStudyBookmarks(cursorIdx, limit) },
            fetch = { profileRepository.fetchStudyBookmarks(cursorIdx, limit) }
        )
}