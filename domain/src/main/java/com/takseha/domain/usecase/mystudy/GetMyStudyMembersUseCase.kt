package com.takseha.domain.usecase.mystudy

import com.takseha.domain.repository.MyStudyRepository

/**
 * 마이스터디 멤버 리스트 조회 (랭킹순)
 */
class GetMyStudyMembersUseCase(
    private val myStudyRepository: MyStudyRepository
) {
    suspend operator fun invoke(studyId: Int) = myStudyRepository.fetchMyStudyMembers(studyId)
}