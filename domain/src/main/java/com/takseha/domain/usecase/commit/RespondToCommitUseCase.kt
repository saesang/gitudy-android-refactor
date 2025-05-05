package com.takseha.domain.usecase.commit

import com.takseha.domain.repository.CommitRepository

/**
 * 커밋 승인/반려
 */
class RespondToCommitUseCase(
    private val commitRepository: CommitRepository
) {
    suspend operator fun invoke(studyId: Int, commitId: Int, isApproved: Boolean) =
        if (isApproved) {
            commitRepository.approveCommit(studyId, commitId)
        } else {
            commitRepository.rejectCommit(studyId, commitId)
        }
}