package com.takseha.domain.usecase.commit

import com.takseha.domain.model.commit.PostCommitCommentParam
import com.takseha.domain.repository.CommitRepository

/**
 * 커밋 댓글 수정
 */
class UpdateCommitCommentUseCase(
    private val commitRepository: CommitRepository
) {
    suspend operator fun invoke(commitId: Int, updateCommitCommentParam: PostCommitCommentParam) =
        commitRepository.updateCommitComment(commitId, updateCommitCommentParam)
}