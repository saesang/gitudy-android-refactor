package com.takseha.core.di

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import com.google.gson.GsonBuilder
import com.takseha.core.BuildConfig
import com.takseha.data.source.remote.api.CommitService
import com.takseha.data.source.remote.api.PlainAuthService
import com.takseha.data.source.remote.api.ProfileService
import com.takseha.data.source.remote.api.SecureAuthService
import com.takseha.data.source.remote.api.StudyService
import com.takseha.data.source.remote.api.StudySettingService
import com.takseha.data.source.remote.api.TodoService
import com.takseha.data.utils.TokenInterceptor
import com.takseha.data.utils.TokenManager
import com.takseha.data.utils.di.Qualifier
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton


/**
 * header에 토큰 인증이 필요한 API는 SecureRetrofit을 사용하고,
 * 인증이 필요하지 않은 API는 PlainRetrofit을 사용하는 방식으로 구분함
 */
@Module
@InstallIn(SingletonComponent::class)
object ApiModule {

    /** TokenInterceptor 사용 X */
    @Singleton
    @Provides
    fun plainAuthService(@Qualifier.PlainRetrofit plainRetrofit: Retrofit): PlainAuthService {
        return plainRetrofit.create(PlainAuthService::class.java)
    }

    /** TokenInterceptor 사용 O */
    @Singleton
    @Provides
    fun secureAuthService(@Qualifier.SecureRetrofit secureRetrofit: Retrofit): SecureAuthService {
        return secureRetrofit.create(SecureAuthService::class.java)
    }

    @Singleton
    @Provides
    fun commitService(@Qualifier.SecureRetrofit secureRetrofit: Retrofit): CommitService {
        return secureRetrofit.create(CommitService::class.java)
    }

    @Singleton
    @Provides
    fun profileService(@Qualifier.SecureRetrofit secureRetrofit: Retrofit): ProfileService {
        return secureRetrofit.create(ProfileService::class.java)
    }

    @Singleton
    @Provides
    fun studyService(@Qualifier.SecureRetrofit secureRetrofit: Retrofit): StudyService {
        return secureRetrofit.create(StudyService::class.java)
    }

    @Singleton
    @Provides
    fun studySettingService(@Qualifier.SecureRetrofit secureRetrofit: Retrofit): StudySettingService {
        return secureRetrofit.create(StudySettingService::class.java)
    }

    @Singleton
    @Provides
    fun todoService(@Qualifier.SecureRetrofit secureRetrofit: Retrofit): TodoService {
        return secureRetrofit.create(TodoService::class.java)
    }



    @Qualifier.SecureRetrofit
    @Singleton
    @Provides
    fun authRetrofit(@Qualifier.SecureOkHttpClient secureOkHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BuildConfig.GITUDY_BASE_URL)
            .client(secureOkHttpClient)
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().setLenient().create()))
            .build()
    }

    @Qualifier.PlainRetrofit
    @Singleton
    @Provides
    fun plainRetrofit(@Qualifier.PlainOkHttpClient plainOkHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BuildConfig.GITUDY_BASE_URL)
            .client(plainOkHttpClient)
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().setLenient().create()))
            .build()
    }

    @Qualifier.SecureOkHttpClient
    @Singleton
    @Provides
    fun secureOkHttpClient(tokenInterceptor: TokenInterceptor): OkHttpClient {
        return OkHttpClient().newBuilder()
            .connectTimeout(15, TimeUnit.SECONDS)
            .readTimeout(15, TimeUnit.SECONDS)
            .writeTimeout(15, TimeUnit.SECONDS)
            .addInterceptor(tokenInterceptor)
            .build()
    }

    @Qualifier.PlainOkHttpClient
    @Singleton
    @Provides
    fun plainOkHttpClient(): OkHttpClient {
        return OkHttpClient().newBuilder()
            .connectTimeout(15, TimeUnit.SECONDS)
            .readTimeout(15, TimeUnit.SECONDS)
            .writeTimeout(15, TimeUnit.SECONDS)
            .build()
    }

    @Singleton
    @Provides
    fun tokenInterceptor(
        @ApplicationContext appContext: Context,
        tokenManager: TokenManager
    ): TokenInterceptor {
        return TokenInterceptor(appContext, tokenManager)
    }


    @Singleton
    @Provides
    fun tokenManager(
        dataStore: DataStore<Preferences>
    ): TokenManager {
        return TokenManager(dataStore)
    }
}