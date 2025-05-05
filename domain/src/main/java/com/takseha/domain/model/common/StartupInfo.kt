package com.takseha.domain.model.common

import com.takseha.domain.model.mystudy.MyStudiesInfo
import com.takseha.domain.model.notification.Notification
import com.takseha.domain.model.profile.StudyBookmark
import com.takseha.domain.model.profile.UserInfo
import com.takseha.domain.model.study.StudiesInfo
import com.takseha.domain.model.todo.CommitSummary

/** 앱 초기화 데이터 model (서버 동기화)
 * : 서버 동기화 실패해도 문제 없음
 * -> 동기화 실패 시 presentation 모듈까지 에러 보내지 않고, 동기화 실패 프로퍼티 값을 null로 처리
 */
data class StartupInfo(
    val userInfo: UserInfo?,
    val notifications: List<Notification>?,
    val myStudiesInfo: MyStudiesInfo?,
    val allStudiesInfo: StudiesInfo?,
    val myCommits: List<CommitSummary>?,
    val studyBookmarks: List<StudyBookmark>?,
)
