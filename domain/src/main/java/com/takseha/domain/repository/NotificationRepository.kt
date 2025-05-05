package com.takseha.domain.repository

import com.takseha.domain.model.notification.Notification

interface NotificationRepository {
    /** 알림 리스트 조회 */
    suspend fun getNotifications(cursorTime: String?, limit: Long): List<Notification>?
    suspend fun fetchNotifications(cursorTime: String?, limit: Long): List<Notification>

    /** 알림 삭제 */
    suspend fun deleteNotification(notificationId: Int)

    /** 전체 알림 삭제 */
    suspend fun deleteAllNotifications()
}