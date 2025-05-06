package com.takseha.data.source.remote.api

import com.takseha.data.source.remote.dto.auth.request.CheckNicknameDuplicationRequest
import com.takseha.data.source.remote.dto.auth.request.SignUpRequest
import com.takseha.data.source.remote.dto.auth.response.TokenInfoResponse
import com.takseha.data.source.remote.dto.study.request.MessageRequest
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

/**
 * 인증 관련 api 정의 인터페이스 (header 토큰 O)
 */
interface SecureAuthService {
    @POST("/auth/register")
    suspend fun signUp(
        @Body request: SignUpRequest
    ): Response<TokenInfoResponse>

    @POST("/auth/reissue")
    suspend fun reissueTokens(
    ): Response<TokenInfoResponse>

    @POST("/auth/logout")
    suspend fun signOut(
    ): Response<Void>

    @POST("/auth/delete")
    suspend fun deleteAccount(
        @Body request: MessageRequest
    ): Response<Void>

    @POST("/auth/check-nickname")
    suspend fun checkNicknameDuplication(
        @Body request: CheckNicknameDuplicationRequest
    ): Response<Void>
}