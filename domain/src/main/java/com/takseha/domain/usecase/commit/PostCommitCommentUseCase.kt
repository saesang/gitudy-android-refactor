package com.takseha.domain.usecase.commit

import com.takseha.domain.model.commit.PostCommitCommentParam
import com.takseha.domain.repository.CommitRepository

/**
 * 커밋 댓글 등록
 */
class PostCommitCommentUseCase(
    private val commitRepository: CommitRepository
) {
    suspend operator fun invoke(commitId: Int, postCommitCommentParam: PostCommitCommentParam) =
        commitRepository.postCommitComment(commitId, postCommitCommentParam)
}