package com.takseha.domain.model.common

/**
Failure: 모든 Exception을 인자로 받아, 발생 계층/종류 별로 구분
- ValidationFailure, BusinessFailure는 에러 상황에 대한 alertMessage를 인자로 가짐
- 나머지 Failure는 exception을 인자로 가짐
 */

sealed class Failure(
    open val alertMessage: String? = null,
    override val cause: Exception? = null
) : Throwable()

// data 계층에서 발생한 exception을 wrapping
class NetworkFailure(e: Exception?) : Failure(cause = e)
class ServerFailure(e: Exception?) : Failure(cause = e)
class DatabaseFailure(e: Exception?) : Failure(cause = e)
class UnexpectedDataFailure(e: Exception?) : Failure(cause = e)

// domain 계층에서 발생한 비즈니스 로직 오류에 대한 알림메세지를 wrapping
class BusinessFailure(alertMessage: String) : Failure(alertMessage = alertMessage)
class ValidationFailure(alertMessage: String) : Failure(alertMessage = alertMessage)

// presentation 계층에서 발생한 exception을 wrapping
class UiFailure(e: Exception?) : Failure(cause = e)
class AppCrashFailure(e: Exception?) : Failure(cause = e)
class UnexpectedUiFailure(e: Exception?) : Failure(cause = e)