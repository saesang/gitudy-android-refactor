package com.takseha.domain.repository

import com.takseha.domain.model.mystudy.MyStudyComment
import com.takseha.domain.model.mystudy.MyStudyDetail
import com.takseha.domain.model.mystudy.MyStudyMember
import com.takseha.domain.model.mystudy.MyStudySummary
import com.takseha.domain.model.mystudy.TodoSummary
import com.takseha.domain.model.study.StudyRank

interface MyStudyRepository {
    /** 마이스터디 리스트 조회 */
    suspend fun getMyStudySummaries(cursorIdx: Long?, limit: Long, sortBy: String): List<MyStudySummary>?
    suspend fun fetchMyStudySummaries(cursorIdx: Long?, limit: Long, sortBy: String): List<MyStudySummary>
    /** 스터디 별 마감일 임박 투두 정보 조회 */
    suspend fun getNearestDeadlineTodoInfo(studyId: Int): TodoSummary?
    suspend fun fetchNearestDeadlineTodoInfo(studyId: Int): TodoSummary?

    /** 마이스터디 개수 조회 */
    suspend fun getMyStudyCount(): Int?
    suspend fun fetchMyStudyCount(): Int

    /** 스터디 랭킹 조회 */
    suspend fun fetchStudyRankAndScore(studyId: Int): StudyRank

    /** 마이스터디 상세 정보 조회 */
    suspend fun getMyStudyDetail(studyId: Int): MyStudyDetail?
    suspend fun fetchMyStudyDetail(studyId: Int): MyStudyDetail
    /** 마이스터디 멤버 리스트 조회 */
    suspend fun fetchMyStudyMembers(studyId: Int): List<MyStudyMember>

    /** 커뮤니티 글 목록 조회 */
    suspend fun getMyStudyComments(cursorIdx: Long?, limit: Long, studyId: Int): List<MyStudyComment>?
    suspend fun fetchMyStudyComments(cursorIdx: Long?, limit: Long, studyId: Int): List<MyStudyComment>
    /** 커뮤니티 글 작성 */
    suspend fun postMyStudyComment(studyId: Int, comment: String)
    /** 커뮤니티 글 수정 */
    suspend fun updateMyStudyComment(studyId: Int, studyCommentId: Int, comment: String)
    /** 커뮤니티 글 삭제 */
    suspend fun deleteMyStudyComment(studyId: Int, studyCommentId: Int)
}