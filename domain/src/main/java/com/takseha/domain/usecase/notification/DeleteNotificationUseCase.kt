package com.takseha.domain.usecase.notification

import com.takseha.domain.repository.NotificationRepository

/**
 * 알림 삭제
 */
class DeleteNotificationUseCase(
    private val notificationRepository: NotificationRepository
) {
    suspend operator fun invoke(notificationId: Int) = notificationRepository.deleteNotification(notificationId)
}