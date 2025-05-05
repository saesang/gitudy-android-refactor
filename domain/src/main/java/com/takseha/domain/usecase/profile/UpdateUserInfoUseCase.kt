package com.takseha.domain.usecase.profile

import com.takseha.domain.model.profile.UpdateUserInfoParam
import com.takseha.domain.repository.ProfileRepository

/**
 * 프로필 정보 수정
 */
class UpdateUserInfoUseCase(
    private val profileRepository: ProfileRepository
) {
    suspend operator fun invoke(updateUserInfoParam: UpdateUserInfoParam) =
        profileRepository.updateUserInfo(updateUserInfoParam)
}