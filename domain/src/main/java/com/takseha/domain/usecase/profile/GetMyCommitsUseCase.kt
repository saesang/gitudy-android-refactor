package com.takseha.domain.usecase.profile

import com.takseha.domain.repository.ProfileRepository
import com.takseha.domain.utils.getOrFetch

/**
 * 마이커밋 리스트 조회
 * : Room 먼저 조회(get) -> null이면 서버에서 조회(fetch)
 */
class GetMyCommitsUseCase(
    private val profileRepository: ProfileRepository
) {
    suspend operator fun invoke(cursorIdx: Long? = null, limit: Long = 3, studyId: Int) =
        getOrFetch(
            get = { profileRepository.getMyCommits(cursorIdx, limit, studyId) },
            fetch = { profileRepository.fetchMyCommits(cursorIdx, limit, studyId) }
        )
}