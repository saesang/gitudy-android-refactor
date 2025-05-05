package com.takseha.domain.usecase.mystudy

import com.takseha.domain.repository.MyStudyRepository

/**
 * 마이스터디 게시글 작성
 */
class PostMyStudyCommentUseCase(
    private val myStudyRepository: MyStudyRepository
) {
    suspend operator fun invoke(studyId: Int, comment: String) = myStudyRepository.postMyStudyComment(studyId, comment)
}