package com.takseha.domain.usecase

import com.takseha.domain.repository.AuthRepository

class CheckUserLoggedInUseCase(
    private val authRepository: AuthRepository
) {
    suspend operator fun invoke() = authRepository.isUserLoggedIn()
}