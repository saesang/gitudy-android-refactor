package com.takseha.data.source.remote.dto.profile.response


import com.google.gson.annotations.SerializedName
import com.takseha.data.source.remote.dto.commit.response.CommitDetailResponse

data class MyCommitsResponse(
    @SerializedName("commit_info_list")
    val myCommits: List<CommitDetailResponse>,
    @SerializedName("cursor_idx")
    val cursorIdx: Int
)