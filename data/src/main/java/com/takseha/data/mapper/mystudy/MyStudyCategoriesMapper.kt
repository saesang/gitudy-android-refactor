package com.takseha.data.mapper.mystudy

import com.takseha.data.source.local.entity.study.StudyCategoryEntity
import com.takseha.data.source.remote.dto.study.response.StudyDetailResponse
import com.takseha.domain.model.mystudy.MyStudyDetail

object MyStudyCategoriesMapper {
    /** dto -> entity */
    fun toEntities(dto: StudyDetailResponse): List<StudyCategoryEntity> =
        dto.categoryNames.map { categoryName ->
            StudyCategoryEntity(
                studyId = dto.id,
                category = categoryName
            )
        }

    /** model -> entity */
    fun toEntities(model: MyStudyDetail): List<StudyCategoryEntity> =
        model.studyCategoryList.map { categoryName ->
            StudyCategoryEntity(
                studyId = model.id,
                category = categoryName
            )
        }
}