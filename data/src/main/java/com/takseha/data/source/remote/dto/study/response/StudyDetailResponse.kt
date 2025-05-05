package com.takseha.data.source.remote.dto.study.response

import com.google.gson.annotations.SerializedName
import com.takseha.domain.model.study.StudyCycle
import com.takseha.domain.model.study.StudyStatus

data class StudyDetailResponse(
    @SerializedName("category_names")
    val categoryNames: List<String> = listOf(),
    @SerializedName("created_date_time")
    val createdDateTime: String = "",
    @SerializedName("current_member")
    val currentMember: Int = 0,
    @SerializedName("id")
    val id: Int = 0,
    @SerializedName("info")
    val info: String = "",
    @SerializedName("last_commit_day")
    val lastCommitDay: String? = "",
    @SerializedName("maximum_member")
    val maximumMember: Int = 0,
    @SerializedName("modified_date_time")
    val modifiedDateTime: String = "",
    @SerializedName("period_type")
    val periodType: StudyCycle,
    @SerializedName("profile_image_url")
    val profileImageUrl: String = "0",
    @SerializedName("score")
    val score: Int = 0,
    @SerializedName("status")
    val status: StudyStatus,
    @SerializedName("topic")
    val topic: String = "",
    @SerializedName("user_id")
    val userId: Int = 0,
    @SerializedName("is_leader")
    val isLeader: Boolean = false,
    @SerializedName("is_waiting")
    val isWaiting: Boolean = false,
    @SerializedName("repository_info")
    val githubLinkInfo: RepositoryInfo = RepositoryInfo()
)

data class RepositoryInfo(
    @SerializedName("owner")
    val owner: String = "",
    @SerializedName("name")
    val name: String = "",
    @SerializedName("branch_name")
    val branchName: String = ""
)