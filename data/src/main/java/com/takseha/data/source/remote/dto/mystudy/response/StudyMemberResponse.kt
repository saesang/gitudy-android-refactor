package com.takseha.data.source.remote.dto.mystudy.response


import com.google.gson.annotations.SerializedName
import com.takseha.domain.model.auth.common.Role
import com.takseha.domain.model.study.StudyApplicantStatus

data class StudyMemberResponse(
    @SerializedName("role")
    val role: Role,
    @SerializedName("score")
    val score: Int,
    @SerializedName("status")
    val status: StudyApplicantStatus,
    @SerializedName("user_id")
    val userId: Int,
    @SerializedName("user_info")
    val info: StudyMemberInfoResponse
)