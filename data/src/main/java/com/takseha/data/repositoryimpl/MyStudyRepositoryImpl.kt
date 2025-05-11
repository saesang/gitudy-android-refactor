package com.takseha.data.repositoryimpl

import com.takseha.data.mapper.exception.ExceptionToFailureMapper
import com.takseha.data.mapper.mystudy.MyStudySummariesMapper
import com.takseha.data.mapper.mystudy.TodoSummaryMapper
import com.takseha.data.source.local.GitudyDatabase
import com.takseha.data.source.remote.api.StudyService
import com.takseha.data.source.remote.dto.study.response.StudiesResponse
import com.takseha.data.source.remote.dto.todo.response.TodoSummaryResponse
import com.takseha.data.utils.safeApiCall
import com.takseha.domain.model.mystudy.MyStudyComment
import com.takseha.domain.model.mystudy.MyStudyDetail
import com.takseha.domain.model.mystudy.MyStudyMember
import com.takseha.domain.model.mystudy.MyStudySummary
import com.takseha.domain.model.mystudy.TodoSummary
import com.takseha.domain.model.study.StudyRank
import com.takseha.domain.repository.MyStudyRepository
import javax.inject.Inject

class MyStudyRepositoryImpl @Inject constructor(
    private val myStudyService: StudyService,
    private val gitudyDatabase: GitudyDatabase
) : MyStudyRepository {
    override suspend fun getMyStudySummaries(
        cursorIdx: Long?,
        limit: Long,
        sortBy: String
    ): List<MyStudySummary>? {
        return try {
            val myStudySummaryEntities = gitudyDatabase.dao().getMyStudySummaries(
                cursorIdx = cursorIdx,
                limit = limit,
                sortBy = sortBy
            )

            MyStudySummariesMapper.toModels(myStudySummaryEntities)
        } catch (e: Exception) {
            throw ExceptionToFailureMapper.map(e)
        }
    }

    override suspend fun fetchMyStudySummaries(
        cursorIdx: Long?,
        limit: Long,
        sortBy: String
    ): List<MyStudySummary> {
        return safeApiCall(
            call = { myStudyService.fetchStudies(cursorIdx = cursorIdx, limit = limit, sortBy = sortBy, myStudy = true) },
            mapper = { MyStudySummariesMapper.toModels(it) },
            successApi = { saveMyStudySummaries(it) }
        )
    }

    override suspend fun getNearestDeadlineTodoInfo(studyId: Int): TodoSummary? {
        return try {
            val todoSummaryEntity = gitudyDatabase.dao().getNearestDeadlineTodoInfo(studyId)

            TodoSummaryMapper.toModel(todoSummaryEntity)
        } catch (e: Exception) {
            throw ExceptionToFailureMapper.map(e)
        }
    }

    override suspend fun fetchNearestDeadlineTodoInfo(studyId: Int): TodoSummary? {
        return safeApiCall(
            call = { myStudyService.fetchNearestDeadlineTodo(studyId) },
            mapper = { TodoSummaryMapper.toModel(it) },
            successApi = { saveNearestDeadlineTodo(it) }
        )
    }

    override suspend fun getMyStudyCount(): Int? {
        TODO("Not yet implemented")
    }

    override suspend fun fetchMyStudyCount(): Int {
        TODO("Not yet implemented")
    }

    override suspend fun fetchStudyRankAndScore(studyId: Int): StudyRank {
        TODO("Not yet implemented")
    }

    override suspend fun getMyStudyDetail(studyId: Int): MyStudyDetail? {
        TODO("Not yet implemented")
    }

    override suspend fun fetchMyStudyDetail(studyId: Int): MyStudyDetail {
        TODO("Not yet implemented")
    }

    override suspend fun fetchMyStudyMembers(studyId: Int): List<MyStudyMember> {
        TODO("Not yet implemented")
    }

    override suspend fun getMyStudyComments(
        cursorIdx: Long?,
        limit: Long,
        studyId: Int
    ): List<MyStudyComment>? {
        TODO("Not yet implemented")
    }

    override suspend fun fetchMyStudyComments(
        cursorIdx: Long?,
        limit: Long,
        studyId: Int
    ): List<MyStudyComment> {
        TODO("Not yet implemented")
    }

    override suspend fun postMyStudyComment(studyId: Int, comment: String) {
        TODO("Not yet implemented")
    }

    override suspend fun updateMyStudyComment(studyId: Int, studyCommentId: Int, comment: String) {
        TODO("Not yet implemented")
    }

    override suspend fun deleteMyStudyComment(studyId: Int, studyCommentId: Int) {
        TODO("Not yet implemented")
    }


    private suspend fun saveMyStudySummaries(myStudySummaries: StudiesResponse) {
        try {
            val myStudySummaryEntities = MyStudySummariesMapper.toEntities(myStudySummaries)
            gitudyDatabase.dao().apply {
                deleteMyStudySummaries()
                insertMyStudySummaries(myStudySummaryEntities)
            }
        } catch (e: Exception) {
            throw ExceptionToFailureMapper.map(e)
        }
    }

    private suspend fun saveNearestDeadlineTodo(nearestDeadlineTodo: TodoSummaryResponse) {
        if (nearestDeadlineTodo.todo == null) return

        try {
            val todoSummaryEntity = TodoSummaryMapper.toEntity(nearestDeadlineTodo)
            gitudyDatabase.dao().apply {
                deleteNearestDeadlineTodoInfos(nearestDeadlineTodo.todo.id)
                insertNearestDeadlineTodoInfo(todoSummaryEntity)
            }
        } catch (e: Exception) {
            throw ExceptionToFailureMapper.map(e)
        }
    }
}