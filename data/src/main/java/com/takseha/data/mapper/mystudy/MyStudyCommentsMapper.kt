package com.takseha.data.mapper.mystudy

import com.takseha.data.source.local.entity.mystudy.MyStudyCommentEntity
import com.takseha.data.source.remote.dto.mystudy.response.CommentResponse
import com.takseha.data.source.remote.dto.study.response.StudiesResponse
import com.takseha.domain.model.mystudy.MyStudyComment
import com.takseha.domain.model.mystudy.MyStudySummary

object MyStudyCommentsMapper {
    /** dto -> entity */
    fun toEntities(dtos: List<CommentResponse>): List<MyStudyCommentEntity> =
        dtos.map {
            MyStudyCommentEntity(
                id = it.id,
                studyId = it.studyInfoId,
                writerName = it.userInfo.name,
                writerProfileUrl = it.userInfo.profileImageUrl,
                content = it.content,
                createdAt = it.commentSetDate,
                isMyComment = it.isMyComment
            )
        }

    /** model -> entity */
    fun toEntities(models: List<MyStudyComment>): List<MyStudyCommentEntity> =
        models.map {
            MyStudyCommentEntity(
                id = it.id,
                studyId = it.studyId,
                writerName = it.writerName,
                writerProfileUrl = it.writerProfileUrl,
                content = it.content,
                createdAt = it.createdAt,
                isMyComment = it.isMyComment
            )
        }

    /** entity -> model */
    fun toModels(entities: List<MyStudyCommentEntity>): List<MyStudyComment> = entities.map {
        MyStudyComment(
            id = it.id,
            studyId = it.studyId,
            writerName = it.writerName,
            writerProfileUrl = it.writerProfileUrl,
            content = it.content,
            createdAt = it.createdAt,
            isMyComment = it.isMyComment
        )
    }

    /** dto -> model */
    fun toModels(dtos: List<CommentResponse>): List<MyStudyComment> = dtos.map {
        MyStudyComment(
            id = it.id,
            studyId = it.studyInfoId,
            writerName = it.userInfo.name,
            writerProfileUrl = it.userInfo.profileImageUrl,
            content = it.content,
            createdAt = it.commentSetDate,
            isMyComment = it.isMyComment
        )
    }
}