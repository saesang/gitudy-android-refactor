package com.takseha.domain.usecase.signup

import com.takseha.domain.repository.AuthRepository

/**
 * 닉네임 중복 여부 확인
 */
class CheckNicknameDuplicationUseCase(
    private val authRepository: AuthRepository
) {
    suspend operator fun invoke(nickname: String) = authRepository.checkNicknameDuplication(
        nickname = nickname
    )
}