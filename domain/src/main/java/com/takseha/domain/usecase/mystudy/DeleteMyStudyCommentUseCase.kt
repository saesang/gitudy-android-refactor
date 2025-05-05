package com.takseha.domain.usecase.mystudy

import com.takseha.domain.repository.MyStudyRepository

/**
 * 마이스터디 게시글 삭제
 */
class DeleteMyStudyCommentUseCase(
    private val myStudyRepository: MyStudyRepository
) {
    suspend operator fun invoke(studyId: Int, studyCommentId: Int) = myStudyRepository.deleteMyStudyComment(studyId, studyCommentId)
}