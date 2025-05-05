package com.takseha.domain.usecase.profile

import com.takseha.domain.repository.AuthRepository

/**
 * 로그아웃
 */
class SignOutUseCase(
    private val authRepository: AuthRepository
) {
    suspend operator fun invoke() = authRepository.signOut()
}