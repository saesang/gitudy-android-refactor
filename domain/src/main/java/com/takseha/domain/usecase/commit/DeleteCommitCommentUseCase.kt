package com.takseha.domain.usecase.commit

import com.takseha.domain.repository.CommitRepository

/**
 * 커밋 댓글 삭제
 */
class DeleteCommitCommentUseCase(
    private val commitRepository: CommitRepository
) {
    suspend operator fun invoke(commitId: Int, commentId: Int) =
        commitRepository.deleteCommitComment(commitId, commentId)
}