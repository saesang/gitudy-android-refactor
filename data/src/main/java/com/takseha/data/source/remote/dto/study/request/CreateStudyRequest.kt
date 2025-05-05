package com.takseha.data.source.remote.dto.study.request


import com.google.gson.annotations.SerializedName
import com.takseha.domain.model.study.StudyCycle
import com.takseha.domain.model.study.StudyStatus

data class CreateStudyRequest(
    @SerializedName("categories_id")
    val categoriesId: List<Int>,
    @SerializedName("info")
    val info: String,
    @SerializedName("maximum_member")
    val maximumMember: Int,
    @SerializedName("period_type")
    val periodType: StudyCycle,
    @SerializedName("profile_image_url")
    val profileImageUrl: String,
    @SerializedName("repository_name")
    val repositoryName: String,
    @SerializedName("status")
    val status: StudyStatus,
    @SerializedName("topic")
    val topic: String
)