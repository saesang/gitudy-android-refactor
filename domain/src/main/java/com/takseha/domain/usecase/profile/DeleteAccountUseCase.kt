package com.takseha.domain.usecase.profile

import com.takseha.domain.repository.AuthRepository

/**
 * 회원탈퇴
 */
class DeleteAccountUseCase(
    private val authRepository: AuthRepository
) {
    suspend operator fun invoke(withdrawalReason: String) = authRepository.deleteAccount(withdrawalReason)
}