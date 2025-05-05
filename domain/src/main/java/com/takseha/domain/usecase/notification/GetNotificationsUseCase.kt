package com.takseha.domain.usecase.notification

import com.takseha.domain.repository.NotificationRepository
import com.takseha.domain.utils.getOrFetch

/**
 * 알림 리스트 조회
 * : Room 먼저 조회(get) -> null이면 서버에서 조회(fetch)
 */
class GetNotificationsUseCase(
    private val notificationRepository: NotificationRepository
) {
    suspend operator fun invoke(cursorTime: String? = null, limit: Long = 20) = getOrFetch(
        get = { notificationRepository.getNotifications( cursorTime, limit) },
        fetch = { notificationRepository.fetchNotifications( cursorTime, limit) }
    )
}