package com.takseha.data.source.remote.dto.mystudy.response


import com.google.gson.annotations.SerializedName

data class StudyCommentsResponse(
    @SerializedName("cursor_idx")
    val cursorIdx: Int,
    @SerializedName("study_comment_list")
    val studyComments: List<CommentResponse>
)