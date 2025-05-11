package com.takseha.data.source.remote.dto.todo.response


import com.google.gson.annotations.SerializedName
import com.takseha.domain.model.mystudy.TodoStatus

data class TodoSummaryResponse(
    @SerializedName("complete_member_count")
    val completeMemberCount: Int,
    @SerializedName("todo")
    val todo: TodoResponse?,
    @SerializedName("total_member_count")
    val totalMemberCount: Int,
    @SerializedName("my_status")
    val myStatus: TodoStatus
)