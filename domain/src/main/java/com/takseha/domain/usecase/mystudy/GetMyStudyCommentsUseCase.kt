package com.takseha.domain.usecase.mystudy

import com.takseha.domain.repository.MyStudyRepository
import com.takseha.domain.utils.getOrFetch

/**
 * 마이스터디 게시글 리스트 조회
 * : Room 먼저 조회(get) -> null이면 서버에서 조회(fetch)
 */
class GetMyStudyCommentsUseCase(
    private val myStudyRepository: MyStudyRepository
) {
    suspend operator fun invoke(cursorIdx: Long? = null, limit: Long = 3, studyId: Int) = getOrFetch(
        get = { myStudyRepository.getMyStudyComments(cursorIdx, limit, studyId) },
        fetch = { myStudyRepository.fetchMyStudyComments(cursorIdx, limit, studyId) }
    )
}