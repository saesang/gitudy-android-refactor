package com.takseha.core.di

import com.takseha.data.repositoryimpl.MyStudyRepositoryImpl
import com.takseha.domain.repository.AuthRepository
import com.takseha.domain.repository.CommitRepository
import com.takseha.domain.repository.MyStudyRepository
import com.takseha.domain.repository.NotificationRepository
import com.takseha.domain.repository.ProfileRepository
import com.takseha.domain.repository.StudyRepository
import com.takseha.domain.repository.TodoRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

// TODO: 추후 주석 해제
@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
//    @Binds
//    abstract fun AuthRepository(repositoryImpl: AuthRepositoryImpl): AuthRepository
//
//    @Binds
//    abstract fun CommitRepository(repositoryImpl: CommitRepositoryImpl): CommitRepository
//
    @Binds
    abstract fun MyStudyRepository(repositoryImpl: MyStudyRepositoryImpl): MyStudyRepository
//
//    @Binds
//    abstract fun MyStudySettingRepository(repository: MyStudySettingRepositoryImpl): MyStudySettingRepository
//
//    @Binds
//    abstract fun NotificationRepository(repository: NotificationRepositoryImpl): NotificationRepository
//
//    @Binds
//    abstract fun ProfileRepository(repository: ProfileRepositoryImpl): ProfileRepository
//
//    @Binds
//    abstract fun StudyRepository(repositoryImpl: StudyRepositoryImpl): StudyRepository
//
//    @Binds
//    abstract fun TodoRepository(repositoryImpl: TodoRepositoryImpl): TodoRepository
}