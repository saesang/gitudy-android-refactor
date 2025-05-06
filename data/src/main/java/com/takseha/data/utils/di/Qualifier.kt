package com.takseha.data.utils.di

import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Qualifier

@Module
@InstallIn(SingletonComponent::class)
object Qualifier {
    @Qualifier
    @Retention(AnnotationRetention.BINARY)
    annotation class SecureRetrofit

    @Qualifier
    @Retention(AnnotationRetention.BINARY)
    annotation class PlainRetrofit

    @Qualifier
    @Retention(AnnotationRetention.BINARY)
    annotation class SecureOkHttpClient

    @Qualifier
    @Retention(AnnotationRetention.BINARY)
    annotation class PlainOkHttpClient
}