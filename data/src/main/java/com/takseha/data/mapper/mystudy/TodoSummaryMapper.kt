package com.takseha.data.mapper.mystudy

import com.takseha.data.source.local.entity.mystudy.TodoSummaryEntity
import com.takseha.data.source.remote.dto.todo.response.TodoSummaryResponse
import com.takseha.domain.model.mystudy.TodoStatus
import com.takseha.domain.model.mystudy.TodoSummary

object TodoSummaryMapper {
    /** dto -> entity */
    fun toEntity(dto: TodoSummaryResponse): TodoSummaryEntity =
        TodoSummaryEntity(
            id = dto.todo!!.id,
            studyId = dto.todo.studyInfoId,
            title = dto.todo.title,
            deadline = dto.todo.todoDate,
            completeMemberCount = dto.completeMemberCount,
            totalMemberCount = dto.totalMemberCount,
            myStatus = dto.myStatus.toString()
        )

    /** model -> entity */
    fun toEntity(model: TodoSummary):  TodoSummaryEntity =
        TodoSummaryEntity(
            id = model.id,
            studyId = model.studyId,
            title = model.title,
            deadline = model.deadline,
            completeMemberCount = model.completeMemberCount,
            totalMemberCount = model.totalMemberCount,
            myStatus = model.myStatus.toString()
        )

    /** entity -> model */
    fun toDomain(entity: TodoSummaryEntity): TodoSummary = TodoSummary(
        id = entity.id,
        studyId = entity.studyId,
        title = entity.title,
        deadline = entity.deadline,
        completeMemberCount = entity.completeMemberCount,
        totalMemberCount = entity.totalMemberCount,
        myStatus = TodoStatus.from(entity.myStatus)
    )
}