package com.takseha.domain.usecase.notification

import com.takseha.domain.repository.NotificationRepository

/**
 * 전체 알림 리스트 삭제
 */
class DeleteAllNotificationsUseCase(
    private val notificationRepository: NotificationRepository
) {
    suspend operator fun invoke() = notificationRepository.deleteAllNotifications()
}