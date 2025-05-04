package com.takseha.domain.usecase.signup

import com.takseha.domain.model.auth.SignUpParam
import com.takseha.domain.repository.AuthRepository

/**
 * 회원가입
 */
class SignUpUseCase(
    private val authRepository: AuthRepository
) {
    suspend operator fun invoke(signUpParam: SignUpParam) = authRepository.signUp(
        signUpParam = signUpParam
    )
}