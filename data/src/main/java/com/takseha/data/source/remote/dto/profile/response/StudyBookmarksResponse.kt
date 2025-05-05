package com.takseha.data.source.remote.dto.profile.response


import com.google.gson.annotations.SerializedName
import com.takseha.data.source.remote.dto.study.response.StudyDetailResponse

data class StudyBookmarksResponse(
    @SerializedName("bookmark_info_list")
    val studyBookmarks: List<StudyBookmarkResponse>,
    @SerializedName("cursor_idx")
    val cursorIdx: Long?
)

data class StudyBookmarkResponse(
    @SerializedName("id")
    val id: Int,
    @SerializedName("study_info_id")
    val studyInfoId: Int,
    @SerializedName("study_info_with_id_response")
    val studyDetail: StudyDetailResponse,
    @SerializedName("user_id")
    val userId: Int,
    @SerializedName("user_info_response")
    val userInfoResponse: UserInfoResponse
)