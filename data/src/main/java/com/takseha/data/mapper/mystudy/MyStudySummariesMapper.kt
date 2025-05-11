package com.takseha.data.mapper.mystudy

import com.takseha.data.source.local.entity.mystudy.MyStudySummaryEntity
import com.takseha.data.source.remote.dto.study.response.StudiesResponse
import com.takseha.domain.model.mystudy.MyStudySummary

object MyStudySummariesMapper {
    /** dto -> entity */
    // TODO: githubRepoUrl 로직 추후 수정
    fun toEntities(dto: StudiesResponse): List<MyStudySummaryEntity> =
        dto.studySummaries.map {
            MyStudySummaryEntity(
                id = it.id,
                studyName = it.topic,
                score = it.score,
                studyProfileUrl = it.profileImageUrl,
                isLeader = it.isLeader
            )
        }

    /** model -> entity */
    fun toEntities(models: List<MyStudySummary>): List<MyStudySummaryEntity> =
        models.map {
            MyStudySummaryEntity(
                id = it.id,
                studyName = it.studyName,
                score = it.score,
                studyProfileUrl = it.studyProfileUrl,
                isLeader = it.isLeader
            )
        }

    /** entity -> model */
    fun toModels(entities: List<MyStudySummaryEntity>): List<MyStudySummary> = entities.map {
        MyStudySummary(
            id = it.id,
            studyName = it.studyName,
            score = it.score,
            studyProfileUrl = it.studyProfileUrl,
            isLeader = it.isLeader
        )
    }

    /** dto -> model */
    fun toModels(dto: StudiesResponse): List<MyStudySummary> = dto.studySummaries.map {
        MyStudySummary(
            id = it.id,
            studyName = it.topic,
            score = it.score,
            studyProfileUrl = it.profileImageUrl,
            isLeader = it.isLeader
        )
    }
}