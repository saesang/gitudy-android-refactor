package com.takseha.domain.usecase.commit

import com.takseha.domain.repository.CommitRepository
import com.takseha.domain.utils.getOrFetch

/**
 * 커밋 댓글 리스트 조회
 * : Room 먼저 조회(get) -> null이면 서버에서 조회(fetch)
 */
class GetCommitCommentsUseCase(
    private val commitRepository: CommitRepository
) {
    suspend operator fun invoke(studyId: Int, commitId: Int) = getOrFetch(
        get = { commitRepository.getCommitComments(studyId, commitId) },
        fetch = { commitRepository.fetchCommitComments(studyId, commitId) }
    )
}