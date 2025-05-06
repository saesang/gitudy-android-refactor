package com.takseha.data.mapper.mystudy

import com.takseha.data.source.local.entity.mystudy.MyStudyCommentEntity
import com.takseha.data.source.remote.dto.mystudy.response.CommentResponse
import com.takseha.domain.model.mystudy.MyStudyComment

object MyStudyCommentsMapper {
    /** dto -> entity */
    fun toEntity(dto: List<CommentResponse>): List<MyStudyCommentEntity> =
        dto.map {
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
    fun toEntity(model: List<MyStudyComment>): List<MyStudyCommentEntity> =
        model.map {
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
    fun toDomain(entity: List<MyStudyCommentEntity>): List<MyStudyComment> = entity.map {
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
}