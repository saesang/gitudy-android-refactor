package com.takseha.domain.utils

/**
 * Room에 저장된 데이터를 먼저 조회(get)하고,
 * 없으면 서버에서 조회(fetch)한 후 리턴하는 공통 유틸 함수
 */
suspend fun <T> getOrFetch(
    get: suspend () -> T?,
    fetch: suspend () -> T
): T = get() ?: fetch()