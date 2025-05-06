package com.takseha.data.mapper.mystudy

import com.takseha.data.source.local.entity.mystudy.applicant.StudyApplicantEntity
import com.takseha.data.source.remote.dto.mystudy.response.StudyApplicantResponse
import com.takseha.domain.model.mystudy.applicant.StudyApplicant
import com.takseha.domain.model.profile.SocialInfo

object StudyApplicantsMapper {
    /** dto -> entity */
    fun toEntity(studyId: Int, dto: List<StudyApplicantResponse>): List<StudyApplicantEntity> =
        dto.map {
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
    fun toEntity(studyId: Int, model: List<StudyApplicant>): List<StudyApplicantEntity> =
        model.map {
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
    fun toDomain(entity: StudyApplicantEntity): StudyApplicant = StudyApplicant(
        id = entity.id,
        name = entity.name,
        githubId = entity.githubId,
        profileUrl = entity.profileUrl,
        profilePublicYn = entity.profilePublicYn,
        signGreeting = entity.signGreeting,
        appliedAt = entity.appliedAt,
        socialInfo = SocialInfo(
            githubLink = entity.githubLink,
            blogLink = entity.blogLink,
            linkedInLink = entity.linkedInLink
        )
    )
}