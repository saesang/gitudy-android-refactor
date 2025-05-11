package com.takseha.data.mapper.mystudy

import com.takseha.data.source.local.entity.study.StudyRankEntity
import com.takseha.data.source.remote.dto.study.response.StudyRankResponse
import com.takseha.data.source.remote.dto.todo.response.TodoSummaryResponse
import com.takseha.domain.model.mystudy.TodoSummary
import com.takseha.domain.model.study.StudyRank

object StudyRankMapper {
    /** dto -> entity */
    fun toEntity(studyId: Int, dto: StudyRankResponse): StudyRankEntity =
        StudyRankEntity(
            studyId = studyId,
            rank = dto.rank,
            score = dto.score
        )

    /** model -> entity */
    fun toEntity(studyId: Int, model: StudyRank): StudyRankEntity =
        StudyRankEntity(
            studyId = studyId,
            rank = model.rank,
            score = model.score
        )

    /** entity -> model */
    fun toModel(entity: StudyRankEntity): StudyRank = StudyRank(
        rank = entity.rank,
        score = entity.score
    )

    /** dto -> model */
    fun toModel(dto: StudyRankResponse): StudyRank = StudyRank(
        rank = dto.rank,
        score = dto.score
    )
}