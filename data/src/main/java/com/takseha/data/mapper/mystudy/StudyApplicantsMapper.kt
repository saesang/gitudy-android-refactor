package com.takseha.data.mapper.mystudy

import com.takseha.data.source.local.entity.mystudy.applicant.StudyApplicantEntity
import com.takseha.data.source.remote.dto.mystudy.response.StudyApplicantResponse
import com.takseha.data.source.remote.dto.study.response.StudiesResponse
import com.takseha.domain.model.mystudy.MyStudySummary
import com.takseha.domain.model.mystudy.applicant.StudyApplicant
import com.takseha.domain.model.profile.SocialInfo

object StudyApplicantsMapper {
    /** dto -> entity */
    fun toEntities(studyId: Int, dtos: List<StudyApplicantResponse>): List<StudyApplicantEntity> =
        dtos.map {
            StudyApplicantEntity(
                id = it.id,
                studyId = studyId,
                name = it.name,
                githubId = it.githubId,
                profileUrl = it.profileImageUrl,
                profilePublicYn = it.profilePublicYn,
                signGreeting = it.joinReason,
                appliedAt = it.createdDateTime,
                githubLink = it.socialInfo?.githubLink,
                blogLink = it.socialInfo?.blogLink,
                linkedInLink = it.socialInfo?.linkedInLink
            )
        }

    /** model -> entity */
    fun toEntities(studyId: Int, models: List<StudyApplicant>): List<StudyApplicantEntity> =
        models.map {
            StudyApplicantEntity(
                id = it.id,
                studyId = studyId,
                name = it.name,
                githubId = it.githubId,
                profileUrl = it.profileUrl,
                profilePublicYn = it.profilePublicYn,
                signGreeting = it.signGreeting,
                appliedAt = it.appliedAt,
                githubLink = it.socialInfo?.githubLink,
                blogLink = it.socialInfo?.blogLink,
                linkedInLink = it.socialInfo?.linkedInLink
            )
        }

    /** entity -> model */
    fun toModels(entities: List<StudyApplicantEntity>): List<StudyApplicant> = entities.map {
        StudyApplicant(
            id = it.id,
            name = it.name,
            githubId = it.githubId,
            profileUrl = it.profileUrl,
            profilePublicYn = it.profilePublicYn,
            signGreeting = it.signGreeting,
            appliedAt = it.appliedAt,
            socialInfo = SocialInfo(
                githubLink = it.githubLink,
                blogLink = it.blogLink,
                linkedInLink = it.linkedInLink
            )
        )
    }

    /** dto -> model */
    fun toModels(dtos: List<StudyApplicantResponse>): List<StudyApplicant> = dtos.map {
        StudyApplicant(
            id = it.id,
            name = it.name,
            githubId = it.githubId,
            profileUrl = it.profileImageUrl,
            profilePublicYn = it.profilePublicYn,
            signGreeting = it.joinReason,
            appliedAt = it.createdDateTime,
            socialInfo = SocialInfo(
                githubLink = it.socialInfo?.githubLink,
                blogLink = it.socialInfo?.blogLink,
                linkedInLink = it.socialInfo?.linkedInLink
            )
        )
    }
}