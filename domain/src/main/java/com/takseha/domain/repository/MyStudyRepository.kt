package com.takseha.domain.repository

import com.takseha.domain.model.mystudy.MyStudyComment
import com.takseha.domain.model.mystudy.MyStudyDetail
import com.takseha.domain.model.mystudy.MyStudyMember
import com.takseha.domain.model.mystudy.MyStudySummary
import com.takseha.domain.model.mystudy.TodoSummary
import com.takseha.domain.model.mystudy.applicant.StudyApplicant

interface MyStudyRepository {
    /** 마이스터디 리스트 조회 */
    suspend fun fetchMyStudies(cursorIdx: Long?, limit: Long, sortBy: String): List<MyStudySummary>
    /** 스터디 별 마감일 임박 Todo 정보 조회 */
    suspend fun fetchNearestDeadlineTodoInfo(studyId: Int): TodoSummary

    /** 마이스터디 개수 조회 */
    suspend fun fetchMyStudyCount(): Int

    /** 스터디 랭킹 조회 */
    suspend fun fetchStudyRank(studyId: Int): Int

    /** 마이스터디 상세 정보 조회 */
    suspend fun getMyStudyDetail(studyId: Int): MyStudyDetail
    suspend fun fetchMyStudyDetail(studyId: Int): MyStudyDetail
    /** 마이스터디 멤버 리스트 조회 */
    suspend fun fetchMyStudyMembers(studyId: Int): List<MyStudyMember>

    /** 커뮤니티 글 목록 조회 */
    suspend fun fetchMyStudyComments(cursorIdx: Long?, limit: Long, studyId: Int): List<MyStudyComment>
    /** 커뮤니티 글 작성 */
    suspend fun postMyStudyComment(studyId: Int, comment: String)
    /** 커뮤니티 글 수정 */
    suspend fun updateMyStudyComment(studyId: Int, studyCommentId: Int, comment: String)
    /** 커뮤니티 글 삭제 */
    suspend fun deleteMyStudyComment(studyId: Int, studyCommentId: Int)

    /** 스터디 신청자 목록 확인 */
    suspend fun fetchStudyApplications(cursorIdx: Long?, limit: Long, studyId: Int): List<StudyApplicant>

    /** 스터디 신청 승인/거절 */
    suspend fun respondToStudyApplication(studyId: Int, applicantId: Int, isAccepted: Boolean)

    /** 스터디 탈퇴 */
    suspend fun withdrawFromStudy(studyId: Int)

    /** 스터디 종료 */
    suspend fun endStudy(studyId: Int)

    /** 스터디 삭제 */
    suspend fun deleteStudy(studyId: Int)
}