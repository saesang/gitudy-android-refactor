package com.takseha.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.takseha.domain.model.common.AppCrashFailure
import com.takseha.domain.model.common.BusinessFailure
import com.takseha.domain.model.common.DatabaseFailure
import com.takseha.domain.model.common.Failure
import com.takseha.domain.model.common.NetworkFailure
import com.takseha.domain.model.common.ServerFailure
import com.takseha.domain.model.common.UiFailure
import com.takseha.domain.model.common.UnexpectedDataFailure
import com.takseha.domain.model.common.UnexpectedUiFailure
import com.takseha.domain.model.common.ValidationFailure
import com.takseha.domain.model.mystudy.MyStudyComment
import com.takseha.domain.model.mystudy.MyStudyDetail
import com.takseha.domain.model.mystudy.MyStudyMember
import com.takseha.domain.model.mystudy.TodoSummary
import com.takseha.domain.usecase.mystudy.GetMyStudyCommentsUseCase
import com.takseha.domain.usecase.mystudy.GetMyStudyDetailUseCase
import com.takseha.domain.usecase.mystudy.GetMyStudyMembersUseCase
import com.takseha.domain.usecase.mystudy.GetMyStudyRankAndScoreUseCase
import com.takseha.domain.usecase.mystudy.GetNearestDeadlineTodoUseCase
import com.takseha.domain.usecase.mystudy.PostMyStudyCommentUseCase
import com.takseha.presentation.view.base.Error
import com.takseha.presentation.view.base.Init
import com.takseha.presentation.view.base.Loading
import com.takseha.presentation.view.base.Success
import com.takseha.presentation.view.base.UiState
import kotlinx.coroutines.async
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

class MyStudyViewModel @Inject constructor(
    private val getMyStudyDetailUseCase: GetMyStudyDetailUseCase,
    private val getMyStudyRankAndScoreUseCase: GetMyStudyRankAndScoreUseCase,
    private val getNearestDeadlineTodoUseCase: GetNearestDeadlineTodoUseCase,
    private val getMyStudyMembersUseCase: GetMyStudyMembersUseCase,
    private val getMyStudyCommentsUseCase: GetMyStudyCommentsUseCase,
    private val postMyStudyCommentUseCase: PostMyStudyCommentUseCase
) : ViewModel() {
    private val _myStudyBasicState = MutableStateFlow<UiState<MyStudyBasicUiModel>>(Init)
    val myStudyBasicState = _myStudyBasicState.asStateFlow()

    private val _commentState = MutableStateFlow<UiState<List<MyStudyComment>?>>(Init)
    val commentState = _commentState.asStateFlow()

    /** 마이스터디 화면 정보 초기화 */
    fun setUiState(studyId: Int) {
        viewModelScope.launch {
            _myStudyBasicState.value = Loading
            _commentState.value = Loading

            try {
                val deferredDetail = async { getMyStudyDetailUseCase.invoke(studyId) }
                val deferredRankAndScore = async { getMyStudyRankAndScoreUseCase.invoke(studyId) }
                val deferredNearestDeadlineTodo = async { getNearestDeadlineTodoUseCase.invoke(studyId) }
                val deferredStudyMembers = async { getMyStudyMembersUseCase.invoke(studyId) }
                val deferredComments = async { getMyStudyCommentsUseCase.invoke(studyId = studyId) }

                val basicInfo = MyStudyBasicUiModel(
                    myStudyDetail = deferredDetail.await(),
                    studyRank = deferredRankAndScore.await().rank,
                    studyScore = deferredRankAndScore.await().score,
                    nearestDeadlineTodo = deferredNearestDeadlineTodo.await(),
                    studyMembers = deferredStudyMembers.await()
                )
                val comments = deferredComments.await()

                _myStudyBasicState.value = Success(basicInfo)
                _commentState.value = Success(comments)
            } catch (failure: Failure) {
                _myStudyBasicState.value = mapToErrorState(failure)
                _commentState.value = mapToErrorState(failure)
            }
        }
    }

    /** 마이스터디 게시글 올리기 */
    fun postComment(studyId: Int, comment: String) {
        viewModelScope.launch {
            _commentState.value = Loading
            try {
                postMyStudyCommentUseCase.invoke(studyId = studyId, comment = comment)
                val newComments = getMyStudyCommentsUseCase.invoke(studyId = studyId)

                _commentState.value = Success(newComments)
            } catch (failure: Failure) {
                _commentState.value = mapToErrorState(failure)
            }
        }
    }

    // TODO: 에러 별 메세지 매핑하기
    private fun mapToErrorState(failure: Failure): Error {
        return when (failure) {
            is AppCrashFailure -> Error("에러가 발생하였습니다. 잠시 후 다시 시도해 주세요.", failure)
            is BusinessFailure -> Error(failure.alertMessage!!, failure)
            is DatabaseFailure -> Error("에러가 발생하였습니다. 잠시 후 다시 시도해 주세요.", failure)
            is NetworkFailure -> Error("에러가 발생하였습니다. 잠시 후 다시 시도해 주세요.", failure)
            is ServerFailure -> Error("에러가 발생하였습니다. 잠시 후 다시 시도해 주세요.", failure)
            is UiFailure -> Error("에러가 발생하였습니다. 잠시 후 다시 시도해 주세요.", failure)
            is UnexpectedDataFailure -> Error("에러가 발생하였습니다. 잠시 후 다시 시도해 주세요.", failure)
            is UnexpectedUiFailure -> Error("에러가 발생하였습니다. 잠시 후 다시 시도해 주세요.", failure)
            is ValidationFailure -> Error(failure.alertMessage!!, failure)
        }
    }
}

data class MyStudyBasicUiModel(
    val myStudyDetail: MyStudyDetail,
    val studyRank: Int,
    val studyScore: Int,
    val nearestDeadlineTodo: TodoSummary? = null,
    val studyMembers: List<MyStudyMember>
)