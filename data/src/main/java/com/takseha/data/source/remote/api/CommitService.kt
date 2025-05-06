package com.takseha.data.source.remote.api

import com.takseha.data.source.remote.dto.commit.request.CommitCommentRequest
import com.takseha.data.source.remote.dto.commit.request.CommitRejectRequest
import com.takseha.data.source.remote.dto.commit.response.CommitDetailResponse
import com.takseha.data.source.remote.dto.mystudy.response.CommentResponse
import com.takseha.data.source.remote.dto.profile.response.MyCommitsResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.PATCH
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.Query

/**
 * 커밋 관련 api 정의 인터페이스
 */
interface CommitService {
    @GET("/commits")
    suspend fun fetchMyCommits(
        @Query("studyInfoId") studyId: Int?,
        @Query("cursorIdx") cursorIdx: Long?,
        @Query("limit") limit: Long
    ): Response<MyCommitsResponse>

    @GET("/commits/{commitId}")
    suspend fun fetchCommitDetail(
        @Path("commitId") commitId: Int,
        @Query("studyInfoId") studyId: Int
    ): Response<CommitDetailResponse>

    @GET("/commits/{commitId}/approve")
    suspend fun approveCommit(
        @Path("commitId") commitId: Int,
        @Query("studyInfoId") studyId: Int
    ): Response<Void>

    @POST("/commits/{commitId}/reject")
    suspend fun rejectCommit(
        @Path("commitId") commitId: Int,
        @Query("studyInfoId") studyId: Int,
        @Body request: CommitRejectRequest
    ): Response<Void>

    @GET("/commits/{commitId}/comments")
    suspend fun fetchCommitComments(
        @Path("commitId") commitId: Int,
        @Query("studyInfoId") studyId: Int
    ): Response<List<CommentResponse>>

    @POST("/commits/{commitId}/comments")
    suspend fun postCommitComment(
        @Path("commitId") commitId: Int,
        @Body request: CommitCommentRequest
    ): Response<Void>

    @PATCH("/commits/{commitId}/comments/{commentId}")
    suspend fun updateCommitComment(
        @Path("commitId") commitId: Int,
        @Path("commentId") commentId: Int,
        @Body request: CommitCommentRequest
    ): Response<Void>

    @DELETE("/commits/{commitId}/comments/{commentId}")
    suspend fun deleteCommitComment(
        @Path("commitId") commitId: Int,
        @Path("commentId") commentId: Int
    ): Response<Void>
}