package com.takseha.data.source.remote.api

import com.takseha.data.source.remote.dto.profile.request.UserInfoUpdateRequest
import com.takseha.data.source.remote.dto.profile.response.UserInfoResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

/**
 * 프로필 관련 api 정의 인터페이스
 */
interface ProfileService {
    @GET("/auth/info")
    suspend fun fetchUserInfo(
    ): Response<UserInfoResponse>

    @GET("/auth/update/pushAlarmYn/{pushAlarmEnable}")
    suspend fun updatePushNotificationEnabled(
        @Path("pushAlarmEnable") isEnabled: Boolean
    ): Response<Void>

    @POST("/auth/update")
    suspend fun updateUserInfo(
        @Body request: UserInfoUpdateRequest
    ): Response<Void>
}