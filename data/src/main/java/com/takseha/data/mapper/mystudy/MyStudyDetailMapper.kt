package com.takseha.data.mapper.mystudy

import com.takseha.data.source.local.entity.mystudy.MyStudyCategoryEntity
import com.takseha.data.source.local.entity.mystudy.MyStudyDetailEntity
import com.takseha.data.source.local.entity.mystudy.applicant.StudyApplicantEntity
import com.takseha.data.source.remote.dto.mystudy.response.StudyApplicantResponse
import com.takseha.data.source.remote.dto.study.response.StudyDetailResponse
import com.takseha.domain.model.mystudy.MyStudyDetail
import com.takseha.domain.model.mystudy.applicant.StudyApplicant
import com.takseha.domain.model.profile.SocialInfo
import com.takseha.domain.model.study.StudyCycle
import com.takseha.domain.model.study.StudyStatus

object MyStudyDetailMapper {
    /** dto -> entity */
    // TODO: githubRepoUrl 로직 추후 수정
    fun toEntity(dto: StudyDetailResponse): MyStudyDetailEntity =
        MyStudyDetailEntity(
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
    fun toEntity(model: MyStudyDetail): MyStudyDetailEntity =
        MyStudyDetailEntity(
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
    fun toDomain(myStudyDetailEntity: MyStudyDetailEntity, myStudyCategoryEntities: List<MyStudyCategoryEntity>): MyStudyDetail = MyStudyDetail(
        id = myStudyDetailEntity.id,
        studyName = myStudyDetailEntity.studyName,
        info = myStudyDetailEntity.info,
        cycle = StudyCycle.from(myStudyDetailEntity.cycle),
        status = StudyStatus.from(myStudyDetailEntity.status),
        studyProfileUrl = myStudyDetailEntity.studyProfileUrl,
        isLeader = myStudyDetailEntity.isLeader,
        githubRepoUrl = myStudyDetailEntity.githubRepoUrl,
        studyCategoryList = myStudyCategoryEntities.map { it.category }
    )
}