package com.takseha.data.mapper.mystudy

import com.takseha.data.source.local.entity.mystudy.MyStudyCategoryEntity
import com.takseha.data.source.remote.dto.study.response.StudyDetailResponse
import com.takseha.domain.model.mystudy.MyStudyDetail

object MyStudyCategoriesMapper {
    /** dto -> entity */
    fun toEntity(dto: StudyDetailResponse): List<MyStudyCategoryEntity> =
        dto.categoryNames.map { categoryName ->
            MyStudyCategoryEntity(
                studyId = dto.id,
                category = categoryName
            )
        }

    /** model -> entity */
    fun toEntity(model: MyStudyDetail): List<MyStudyCategoryEntity> =
        model.studyCategoryList.map { categoryName ->
            MyStudyCategoryEntity(
                studyId = model.id,
                category = categoryName
            )
        }

    /** entity -> model */
    fun toDomain(entity: List<MyStudyCategoryEntity>): List<String> = entity.map {
        it.category
    }
}