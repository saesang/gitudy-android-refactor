package com.takseha.data.source.remote.api

import com.takseha.data.source.remote.dto.mystudy.response.StudyApplicantsResponse
import com.takseha.data.source.remote.dto.study.request.MessageRequest
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.PATCH
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.Query

/**
 * 스터디 세팅 관련 api 정의 인터페이스
 */
interface StudySettingService {
    @DELETE("/study/{studyInfoId}")
    suspend fun deleteStudy(
        @Path("studyInfoId") studyId: Int
    ): Response<Void>

    @DELETE("/study/{studyInfoId}/close")
    suspend fun endStudy(
        @Path("studyInfoId") studyId: Int
    ): Response<Void>

    @GET("/member/{studyInfoId}/apply")
    suspend fun fetchStudyApplications(
        @Path("studyInfoId") studyId: Int,
        @Query("cursorIdx") cursorIdx: Long?,
        @Query("limit") limit: Long,
    ): Response<StudyApplicantsResponse>

    @POST("/member/{studyInfoId}/notify/leader")
    suspend fun notifyToLeader(
        @Path("studyInfoId") studyId: Int,
        @Body request: MessageRequest
    ): Response<Void>

    @PATCH("/member/{studyInfoId}/apply/{applyUserId}")
    suspend fun respondToStudyApplication(
        @Path("studyInfoId") studyId: Int,
        @Path("applyUserId") applicantId: Int,
        @Query("approve") isAccepted: Boolean
    ): Response<Void>

    @PATCH("/member/{studyInfoId}/withdrawal")
    suspend fun withdrawFromStudy(
        @Path("studyInfoId") studyId: Int
    ): Response<Void>
}