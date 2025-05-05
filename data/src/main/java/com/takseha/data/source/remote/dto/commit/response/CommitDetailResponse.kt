package com.takseha.data.source.remote.dto.commit.response


import com.google.gson.annotations.SerializedName
import com.takseha.domain.model.todo.CommitStatus

data class CommitDetailResponse(
    @SerializedName("commit_date")
    val commitDate: String,
    @SerializedName("commit_sha")
    val commitSha: String,
    @SerializedName("id")
    val id: Int,
    @SerializedName("like_count")
    val likeCount: LikeCount,
    @SerializedName("message")
    val message: String?,
    @SerializedName("rejection-reason")
    val rejectionReason: String?,
    @SerializedName("status")
    val status: CommitStatus,
    @SerializedName("study_info_id")
    val studyInfoId: Int,
    @SerializedName("study_todo_id")
    val studyTodoId: Int,
    @SerializedName("user_id")
    val userId: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("profile_image_url")
    val profileImageUrl: String?
)

data class LikeCount(
    @SerializedName("like_count")
    val likeCount: Int
)