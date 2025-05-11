package com.takseha.domain.repository

import com.takseha.domain.model.mystudy.applicant.StudyApplicant

interface MyStudySettingRepository {
    /** 스터디 신청자 목록 확인 */
    suspend fun getStudyApplications(cursorIdx: Long?, limit: Long, studyId: Int): List<StudyApplicant>?
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