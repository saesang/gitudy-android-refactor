package com.takseha.data.mapper.mystudy

import com.takseha.data.source.local.entity.mystudy.MyStudyDetailWithoutCategoryEntity
import com.takseha.data.source.local.entity.study.StudyCategoryEntity
import com.takseha.data.source.remote.dto.study.response.StudyDetailResponse
import com.takseha.data.source.remote.dto.todo.response.TodoSummaryResponse
import com.takseha.domain.model.mystudy.MyStudyDetail
import com.takseha.domain.model.mystudy.TodoSummary
import com.takseha.domain.model.study.StudyCycle
import com.takseha.domain.model.study.StudyStatus

object MyStudyDetailMapper {
    /** dto -> entity */
    // TODO: githubRepoUrl 로직 추후 수정
    fun toEntity(dto: StudyDetailResponse): MyStudyDetailWithoutCategoryEntity =
        MyStudyDetailWithoutCategoryEntity(
            id = dto.id,
            studyName = dto.topic,
            info = dto.info,
            cycle = dto.periodType.toString(),
            status = dto.status.toString(),
            studyProfileUrl = dto.profileImageUrl,
            isLeader = dto.isLeader,
            githubRepoUrl = dto.githubLinkInfo.branchName
        )

    /** model -> entity */
    fun toEntity(model: MyStudyDetail): MyStudyDetailWithoutCategoryEntity =
        MyStudyDetailWithoutCategoryEntity(
            id = model.id,
            studyName = model.studyName,
            info = model.info,
            cycle = model.cycle.toString(),
            status = model.status.toString(),
            studyProfileUrl = model.studyProfileUrl,
            isLeader = model.isLeader,
            githubRepoUrl = model.githubRepoUrl
        )

    /** entity -> model */
    fun toModel(myStudyDetailWithoutCategoryEntity: MyStudyDetailWithoutCategoryEntity, myStudyCategoryEntities: List<StudyCategoryEntity>): MyStudyDetail = MyStudyDetail(
        id = myStudyDetailWithoutCategoryEntity.id,
        studyName = myStudyDetailWithoutCategoryEntity.studyName,
        info = myStudyDetailWithoutCategoryEntity.info,
        cycle = StudyCycle.from(myStudyDetailWithoutCategoryEntity.cycle),
        status = StudyStatus.from(myStudyDetailWithoutCategoryEntity.status),
        studyProfileUrl = myStudyDetailWithoutCategoryEntity.studyProfileUrl,
        isLeader = myStudyDetailWithoutCategoryEntity.isLeader,
        githubRepoUrl = myStudyDetailWithoutCategoryEntity.githubRepoUrl,
        studyCategoryList = myStudyCategoryEntities.map { it.category }
    )

    /** dto -> model */
    fun toModel(dto: StudyDetailResponse): MyStudyDetail = MyStudyDetail(
        id = dto.id,
        studyName = dto.topic,
        info = dto.info,
        cycle = dto.periodType,
        status = dto.status,
        studyProfileUrl = dto.profileImageUrl,
        isLeader = dto.isLeader,
        githubRepoUrl = dto.githubLinkInfo.branchName,
        studyCategoryList = dto.categoryNames
    )
}