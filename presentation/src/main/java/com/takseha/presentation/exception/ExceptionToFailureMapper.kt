package com.takseha.presentation.exception

import com.takseha.domain.model.common.Failure
import java.io.IOException
import java.nio.BufferOverflowException

class ExceptionToFailureMapper {
    companion object {
        fun map(e: Exception): Failure {
            return when (e) {
                /** App Crash 발생 */
                is IllegalStateException, is NullPointerException, is IllegalArgumentException, is OutOfMemoryError -> {
                    Failure.AppCrashFailure(e)
                }

                /** 데이터 접근 실패 */
                is IndexOutOfBoundsException, is BufferOverflowException, is IOException -> {
                    Failure.UiFailure(e)
                }

                /** 기타 Presentation layer 오류 */
                else -> {
                    Failure.UnexpectedUiFailure(e)
                }
            }
        }
    }
}
