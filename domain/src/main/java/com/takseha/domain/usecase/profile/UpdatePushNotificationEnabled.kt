package com.takseha.domain.usecase.profile

import com.takseha.domain.repository.ProfileRepository

/**
 * 푸시 알림 사용 여부 수정
 */
class UpdatePushNotificationEnabled(
    private val profileRepository: ProfileRepository
) {
    suspend operator fun invoke(isEnabled: Boolean) =
        profileRepository.updatePushNotificationEnabled(isEnabled)
}