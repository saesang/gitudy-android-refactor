package com.takseha.data.utils

import com.takseha.data.mapper.exception.ExceptionToFailureMapper
import com.takseha.domain.model.common.ServerFailure
import retrofit2.Response

suspend fun <T, R> safeApiCall(
    call: suspend () -> Response<T>,
    mapper: (T) -> R,
    successApi: (suspend (T) -> Unit)? = null
): R {
    return try {
        val response = call.invoke()
        val body = response.body()

        when {
            !response.isSuccessful -> {   // response.code != 200
                val statusCode = response.code()
                val errorDesc = "HTTP Error($statusCode)"

                throw ServerFailure(Exception(errorDesc))
            }

            body == null -> {   // null 반환
                throw ServerFailure(Exception("null 반환"))
            }

            else -> {
                successApi?.let { apiCall ->
                    apiCall(body)
                }
                mapper(body)
            }
        }
    } catch (e: Exception) {
        throw ExceptionToFailureMapper.map(e)   // 에러 발생 시 자동으로 Failure로 래핑해서 throw
    }
}