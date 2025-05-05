package com.takseha.domain.usecase.mystudy

import com.takseha.domain.repository.MyStudyRepository

/**
 * 마이스터디 게시글 수정
 */
class UpdateMyStudyCommentUseCase(
    private val myStudyRepository: MyStudyRepository
) {
    suspend operator fun invoke(studyId: Int, studyCommentId: Int, comment: String) = myStudyRepository.updateMyStudyComment(studyId, studyCommentId, comment)
}