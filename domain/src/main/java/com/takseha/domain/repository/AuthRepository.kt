package com.takseha.domain.repository

import com.takseha.domain.model.auth.TokenInfo
import com.takseha.domain.model.auth.SignInPageInfo
import com.takseha.domain.model.auth.SignUpParam

interface AuthRepository {
    /** 로그인 페이지 url 조회 */
    suspend fun getSignInPages(): SignInPageInfo
    suspend fun fetchSignInPages(): SignInPageInfo

    /** 사용자 세션이 유효한 지 확인 */
    suspend fun isUserLoggedIn(): Boolean

    /** 로그인 */
    suspend fun signIn(platformType: String, code: String, state: String): TokenInfo

    /** 회원가입 */
    suspend fun signUp(signUpParam: SignUpParam): TokenInfo
    /** 닉네임 중복 여부 확인 */
    suspend fun checkNicknameDuplication(nickname: String): Boolean

    /** 로그아웃 */
    suspend fun signOut()

    /** 회원탈퇴 */
    suspend fun deleteAccount(withdrawalReason: String)
}