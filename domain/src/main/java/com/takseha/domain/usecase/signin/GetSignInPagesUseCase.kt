package com.takseha.domain.usecase.signin

import com.takseha.domain.repository.AuthRepository

/**
 * 로그인 페이지 url 조회
 */
class GetSignInPagesUseCase(
    private val authRepository: AuthRepository
) {
    suspend operator fun invoke() = authRepository.fetchSignInPages()
}