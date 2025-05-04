package com.takseha.domain.usecase.splash

import com.takseha.domain.repository.AuthRepository

/**
 * 사용자 로그인 여부 확인
 */
class CheckUserLoggedInUseCase(
    private val authRepository: AuthRepository
) {
    suspend operator fun invoke() = authRepository.isUserLoggedIn()
}