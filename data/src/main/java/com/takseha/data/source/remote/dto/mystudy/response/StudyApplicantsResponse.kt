package com.takseha.data.source.remote.dto.mystudy.response


import com.google.gson.annotations.SerializedName
import com.takseha.data.source.remote.dto.profile.response.SocialInfoResponse

data class StudyApplicantsResponse(
    @SerializedName("apply_list")
    val applicants: List<StudyApplicantResponse>,
    @SerializedName("study_topic")
    val studyTopic: String,
    @SerializedName("cursor_idx")
    val cursorIdx: Int?
)

data class StudyApplicantResponse(
    @SerializedName("github_id")
    val githubId: String,
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("point")
    val point: Int,
    @SerializedName("profile_image_url")
    val profileImageUrl: String,
    @SerializedName("profile_public_yn")
    val profilePublicYn: Boolean,
    @SerializedName("score")
    val score: Int,
    @SerializedName("sign_greeting")
    val joinReason: String,
    @SerializedName("created_date_time")
    val createdDateTime: String,
    @SerializedName("social_info")
    val socialInfo: SocialInfoResponse?,
    @SerializedName("user_id")
    val userId: Int
)