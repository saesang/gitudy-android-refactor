package com.takseha.data.source.remote.api

import com.takseha.data.source.remote.dto.mystudy.request.CommentRequest
import com.takseha.data.source.remote.dto.mystudy.response.CategoriesResponse
import com.takseha.data.source.remote.dto.mystudy.response.StudyCommentsResponse
import com.takseha.data.source.remote.dto.mystudy.response.StudyMemberResponse
import com.takseha.data.source.remote.dto.profile.response.StudyBookmarkResponse
import com.takseha.data.source.remote.dto.profile.response.StudyBookmarksResponse
import com.takseha.data.source.remote.dto.study.request.CheckRepoNameDuplicationRequest
import com.takseha.data.source.remote.dto.study.request.CreateStudyRequest
import com.takseha.data.source.remote.dto.study.request.MessageRequest
import com.takseha.data.source.remote.dto.study.response.CategoryResponse
import com.takseha.data.source.remote.dto.study.response.StudiesResponse
import com.takseha.data.source.remote.dto.study.response.StudyCountResponse
import com.takseha.data.source.remote.dto.study.response.StudyDetailResponse
import com.takseha.data.source.remote.dto.study.response.StudyRankResponse
import com.takseha.data.source.remote.dto.todo.response.TodoSummaryResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.PATCH
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.Query

/**
 * 스터디 관련 api 정의 인터페이스
 */
interface StudyService {
    @GET("/study/")
    suspend fun fetchStudies(
        @Query("cursorIdx") cursorIdx: Long?,
        @Query("limit") limit: Long,
        @Query("sortBy") sortBy: String,
        @Query("myStudy") myStudy: Boolean
    ): Response<StudiesResponse>

    @GET("/study/count")
    suspend fun fetchStudyCount(
        @Query("myStudy") myStudy: Boolean
    ): Response<StudyCountResponse>

    @GET("/category/")
    suspend fun fetchAllCategories(
    ): Response<List<CategoryResponse>>

    @GET("/category/{studyInfoId}")
    suspend fun fetchStudyCategories(
        @Path("studyInfoId") studyId: Int,
        @Query("cursorIdx") cursorIdx: Long?,
        @Query("limit") limit: Int
    ): Response<CategoriesResponse>

    @GET("/study/rank/{studyInfoId}")
    suspend fun fetchStudyRankAndScore(
        @Path("studyInfoId") studyId: Int
    ): Response<StudyRankResponse>

    @GET("/bookmarks")
    suspend fun fetchStudyBookmarks(
        @Query("cursorIdx") cursorIdx: Long?,
        @Query("limit") limit: Long
    ): Response<StudyBookmarksResponse>

    @GET("/bookmarks/study/{studyInfoId}")
    suspend fun toggleStudyBookmark(
        @Path("studyInfoId") studyId: Int
    ): Response<Void>

    @GET("/bookmarks/study/{studyInfoId}/my-bookmark")
    suspend fun fetchStudyBookmark(
        @Path("studyInfoId") studyId: Int
    ): Response<StudyBookmarkResponse>

    @POST("/study/check-name")
    suspend fun checkRepoNameDuplication(
        @Body request: CheckRepoNameDuplicationRequest
    ): Response<Void>

    @POST("/study/")
    suspend fun createStudy(
        @Body request: CreateStudyRequest
    ): Response<Void>

    @GET("/study/{studyInfoId}/todo/progress")
    suspend fun fetchNearestDeadlineTodo(
        @Path("studyInfoId") studyId: Int
    ): Response<TodoSummaryResponse>

    @GET("/study/{studyInfoId}")
    suspend fun fetchStudyDetail(
        @Path("studyInfoId") studyId: Int
    ): Response<StudyDetailResponse>

    @POST("/member/{studyInfoId}/apply")
    suspend fun submitStudyApplication(
        @Path("studyInfoId") studyId: Int,
        @Query("joinCode") joinCode: String,
        @Body request: MessageRequest
    ): Response<Void>

    @DELETE("/member/{studyInfoId}/apply")
    suspend fun cancelStudyApplication(
        @Path("studyInfoId") studyId: Int
    ): Response<Void>

    @GET("/member/{studyInfoId}")
    suspend fun fetchStudyMembers(
        @Path("studyInfoId") studyId: Int,
        @Query("orderByScore") orderByScore: Boolean?
    ): Response<List<StudyMemberResponse>>

    @GET("/study/{studyInfoId}/comments")
    suspend fun fetchMyStudyComments(
        @Path("studyInfoId") studyId: Int,
        @Query("cursorIdx") cursorIdx: Long?,
        @Query("limit") limit: Long
    ): Response<StudyCommentsResponse>

    @POST("/study/{studyInfoId}/comment")
    suspend fun postMyStudyComment(
        @Path("studyInfoId") studyId: Int,
        @Body request: CommentRequest
    ): Response<Void>

    @PATCH("/study/{studyInfoId}/comment/{studyCommentId}")
    suspend fun updateMyStudyComment(
        @Path("studyInfoId") studyId: Int,
        @Path("studyCommentId") studyCommentId: Int,
        @Body request: CommentRequest
    ): Response<Void>

    @DELETE("/study/{studyInfoId}/comment/{studyCommentId}")
    suspend fun deleteMyStudyComment(
        @Path("studyInfoId") studyId: Int,
        @Path("studyCommentId") studyCommentId: Int
    ): Response<Void>
}