package com.takseha.data.mapper.exception

import android.database.sqlite.SQLiteConstraintException
import android.database.sqlite.SQLiteException
import com.google.gson.JsonParseException
import com.google.gson.JsonSyntaxException
import com.takseha.domain.model.common.Failure
import retrofit2.HttpException
import java.net.ConnectException
import java.net.SocketTimeoutException
import java.net.UnknownHostException
import java.util.concurrent.TimeoutException

class ExceptionToFailureMapper {
    companion object {
        fun map(e: Exception): Failure {
            return when (e) {
                /** 서버 관련 오류 */
                is ConnectException, is SocketTimeoutException, is HttpException -> {
                    Failure.ServerFailure(e)
                }

                /** 인터넷 연결 실패 */
                is TimeoutException, is UnknownHostException -> {
                    Failure.NetworkFailure(e)
                }

                /** db 오류 */
                is JsonSyntaxException, is JsonParseException, is SQLiteConstraintException, is SQLiteException -> {
                    Failure.DatabaseFailure(e)
                }

                /** 기타 Data Layer 오류 */
                else -> {
                    Failure.UnexpectedDataFailure(e)
                }
            }
        }
    }
}
