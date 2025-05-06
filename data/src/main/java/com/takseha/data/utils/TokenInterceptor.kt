package com.takseha.data.utils

import android.content.Context
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.runBlocking
import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response
import javax.inject.Inject

// TODO: TokenAuthenticator 추후 구현
class TokenInterceptor @Inject constructor(
    @ApplicationContext val context: Context,
    private val tokenManager: TokenManager
) : Interceptor {
    private companion object {
        const val HEADER_AUTH = "Authorization"
    }

    override fun intercept(chain: Interceptor.Chain): Response {
        // dataStore에 저장된 token 불러오기
        val accessToken = runBlocking { tokenManager.getAccessToken() }

        // request header에 access_token 추가
        val request = addTokenToRequest(chain.request(), accessToken)

        return chain.proceed(request)
    }

    private fun addTokenToRequest(
        request: Request,
        accessToken: String
    ): Request {
        return request.newBuilder()
            .header(HEADER_AUTH, "Bearer $accessToken")
            .build()
    }
}