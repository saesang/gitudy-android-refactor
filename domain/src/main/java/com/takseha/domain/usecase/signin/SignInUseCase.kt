package com.takseha.domain.usecase.signin

import com.takseha.domain.repository.AuthRepository

/**
 * 로그인
 */
class SignInUseCase(
    private val authRepository: AuthRepository
) {
    suspend operator fun invoke(platformType: String, code: String, state: String) = authRepository.signIn(
        platformType = platformType,
        code = code,
        state = state
    )
}