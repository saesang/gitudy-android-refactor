package com.takseha.data.source.remote.dto.todo.response

import com.google.gson.annotations.SerializedName
import com.takseha.data.source.remote.dto.commit.response.CommitDetailResponse

data class TodoResponse(
    @SerializedName("detail")
    val detail: String,
    @SerializedName("id")
    val id: Int,
    @SerializedName("study_info_id")
    val studyInfoId: Int,
    @SerializedName("title")
    val title: String,
    @SerializedName("todo_date")
    val todoDate: String,
    @SerializedName("todo_folder_name")
    val todoFolderName: String,
    @SerializedName("todo_link")
    val todoLink: String,
    @SerializedName("created_date_time")
    val todoSetDate: String,
    @SerializedName("commits")
    val commitList: List<CommitDetailResponse>
)
