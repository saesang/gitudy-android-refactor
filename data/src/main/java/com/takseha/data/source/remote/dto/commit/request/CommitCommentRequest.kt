package com.takseha.data.source.remote.dto.commit.request


import com.google.gson.annotations.SerializedName

data class CommitCommentRequest(
    @SerializedName("content")
    val comment: String,
    @SerializedName("study_info_id")
    val studyId: Int
)