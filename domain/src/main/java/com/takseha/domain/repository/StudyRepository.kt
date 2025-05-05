package com.takseha.domain.repository

import com.takseha.domain.model.study.Category
import com.takseha.domain.model.study.CreateStudyParam
import com.takseha.domain.model.study.StudyDetail
import com.takseha.domain.model.study.StudySummary

interface StudyRepository {
    /** 전체 스터디 리스트 조회 */
    suspend fun fetchAllStudySummaries(cursorIdx: Long?, limit: Long, sortBy: String): List<StudySummary>

    /** 전체 스터디 개수 조회 */
    suspend fun fetchTotalStudyCount(): Int

    /** 스터디 랭킹 조회 */
    suspend fun fetchStudyRank(studyId: Int): Int

    /** 스터디 북마크 조회 */
    suspend fun getStudyBookmark(studyId: Int): Boolean
    suspend fun fetchStudyBookmark(studyId: Int): Boolean

    /** 스터디 상세 정보 조회 */
    suspend fun fetchStudyDetail(studyId: Int): StudyDetail

    /** 스터디 생성 */
    suspend fun createStudy(createStudyParam: CreateStudyParam)
    /** 깃허브 레포지토리 이름 중복 체크 */
    suspend fun checkRepoNameDuplication(repoName: String): Boolean
    /** 스터디 카테고리 조회 */
    suspend fun getAllCategories(): List<Category>
    suspend fun fetchAllCategories(): List<Category>

    /** 스터디 신청 */
    suspend fun submitStudyApplication()

    /** 스터디 신청 취소 */
    suspend fun cancelStudyApplication(withdrawalReason: String)
}