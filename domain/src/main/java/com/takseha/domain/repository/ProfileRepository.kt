package com.takseha.domain.repository

import com.takseha.domain.model.profile.StudyBookmark
import com.takseha.domain.model.profile.UpdateUserInfoParam
import com.takseha.domain.model.profile.UserInfo
import com.takseha.domain.model.todo.CommitSummary

interface ProfileRepository {
    /** 사용자 정보 조회 */
    suspend fun getUserInfo(): UserInfo
    suspend fun fetchUserInfo(): UserInfo

    /** 사용자 정보 업데이트 */
    suspend fun updateUserInfo(updateUserInfoParam: UpdateUserInfoParam)
    /** 푸시 알림 사용 여부 업데이트 */
    suspend fun updatePushNotificationEnabled(isEnabled: Boolean)
    /** 닉네임 중복 체크 */
    suspend fun checkNicknameDuplication(nickname: String): Boolean

    /** 마이커밋 리스트 조회 */
    suspend fun getMyCommits(cursorIdx: Long?, limit: Long, studyId: Int?): List<CommitSummary>
    suspend fun fetchMyCommits(cursorIdx: Long?, limit: Long, studyId: Int?): List<CommitSummary>

    /** 스터디 북마크 리스트 조회 */
    suspend fun getStudyBookmarks(cursorIdx: Long?, limit: Long): List<StudyBookmark>
    suspend fun fetchStudyBookmarks(cursorIdx: Long?, limit: Long): List<StudyBookmark>

    /** 스터디 북마크 업데이트 */
    suspend fun updateStudyBookmark(studyId: Int)
}