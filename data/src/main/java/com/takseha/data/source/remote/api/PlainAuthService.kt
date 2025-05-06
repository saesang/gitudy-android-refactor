package com.takseha.data.source.remote.api

import com.takseha.data.source.remote.dto.auth.request.AdminSignInRequest
import com.takseha.data.source.remote.dto.auth.response.SignInPageInfoResponse
import com.takseha.data.source.remote.dto.auth.response.TokenInfoResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.Query

/**
 * 인증 관련 api 정의 인터페이스 (header 토큰 X)
 */
interface PlainAuthService {
    @GET("/auth/loginPage")
    suspend fun fetchSignInPages(): Response<SignInPageInfoResponse>

    @GET("/auth/{platformType}/login")
    suspend fun signIn(
        @Path("platformType") platformType: String,
        @Query("code") code: String,
        @Query("state") state: String
    ): Response<TokenInfoResponse>

    @POST("/auth/admin")
    suspend fun signInAsAdmin(
        @Body request: AdminSignInRequest
    ): Response<TokenInfoResponse>
}