package com.takseha.domain.usecase.study

import com.takseha.domain.repository.StudyRepository
import com.takseha.domain.utils.getOrFetch

/**
 * 전체 카테고리 리스트 조회
 * : Room 먼저 조회(get) -> null이면 서버에서 조회(fetch)
 */
class GetAllCategoriesUseCase(
    private val studyRepository: StudyRepository
) {
    suspend operator fun invoke() = getOrFetch(
        get = { studyRepository.getAllCategories() },
        fetch = { studyRepository.fetchAllCategories() }
    )
}