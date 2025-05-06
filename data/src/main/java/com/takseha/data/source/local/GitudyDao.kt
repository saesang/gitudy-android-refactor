package com.takseha.data.source.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.takseha.data.source.local.entity.mystudy.MyStudyCommentEntity
import com.takseha.data.source.local.entity.mystudy.MyStudyCountEntity
import com.takseha.data.source.local.entity.mystudy.MyStudyDetailEntity
import com.takseha.data.source.local.entity.mystudy.MyStudySummaryEntity
import com.takseha.data.source.local.entity.mystudy.TodoSummaryEntity
import com.takseha.data.source.local.entity.mystudy.applicant.StudyApplicantEntity

@Dao
interface GitudyDao {
    /** 마이스터디 아이템 정보 */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMyStudySummaries(myStudySummaries: List<MyStudySummaryEntity>)
    @Query("Select * From MyStudySummary ORDER BY id DESC LIMIT :limit")
    suspend fun getMyStudySummaries(cursorIdx: Long?, limit: Long, sortBy: String): List<MyStudySummaryEntity>
    @Query("Delete From MyStudySummary")
    suspend fun deleteMyStudySummaries()

    /** 스터디 별 마감일 임박 투두 정보 */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertNearestDeadlineTodoInfo(nearestDeadlineTodoInfo: TodoSummaryEntity)
    @Query("Select * From TodoSummary Where studyId = :studyId")
    suspend fun getNearestDeadlineTodoInfo(studyId: Int): TodoSummaryEntity
    @Query("Delete From TodoSummary")
    suspend fun deleteNearestDeadlineTodoInfos()

    /** 마이스터디 개수 */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMyStudyCount(myStudyCount: MyStudyCountEntity)
    @Query("Select * From MyStudyCount")
    suspend fun getMyStudyCount(): MyStudyCountEntity
    @Query("Delete From MyStudyCount")
    suspend fun deleteMyStudyCount()

    /** 마이스터디 상세 정보 */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMyStudyDetail(myStudyDetail: MyStudyDetailEntity)
    @Query("Select * From MyStudyDetail Where id = :studyId")
    suspend fun getMyStudyDetail(studyId: Int): MyStudyDetailEntity
    @Query("Delete From MyStudyDetail")
    suspend fun deleteMyStudyDetail()

    /** 커뮤니티 게시글 정보 */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMyStudyComments(myStudyComments: List<MyStudyCommentEntity>)
    @Query("Select * From MyStudyComment Where studyId = :studyId ORDER BY id DESC LIMIT :limit")
    suspend fun getMyStudyComments(cursorIdx: Long?, limit: Long, studyId: Int): List<MyStudyCommentEntity>
    @Query("Delete From MyStudyComment")
    suspend fun deleteMyStudyComments()

    /** 스터디 신청자 정보 */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertStudyApplications(studyApplications: List<StudyApplicantEntity>)
    @Query("Select * From StudyApplicant Where studyId = :studyId ORDER BY id DESC LIMIT :limit")
    suspend fun getStudyApplications(cursorIdx: Long?, limit: Long, studyId: Int): List<StudyApplicantEntity>
    @Query("Delete From StudyApplicant")
    suspend fun deleteStudyApplications()
}