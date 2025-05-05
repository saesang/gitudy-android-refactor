package com.takseha.domain.usecase.home

import com.takseha.domain.repository.ProfileRepository
import com.takseha.domain.utils.getOrFetch

/**
 * 사용자 정보 조회
 * : Room 먼저 조회(get) -> null이면 서버에서 조회(fetch)
 */
class GetUserInfoUseCase(
    private val profileRepository: ProfileRepository
) {
    suspend operator fun invoke() = getOrFetch(
        get = { profileRepository.getUserInfo() },
        fetch = { profileRepository.fetchUserInfo() }
    )
}