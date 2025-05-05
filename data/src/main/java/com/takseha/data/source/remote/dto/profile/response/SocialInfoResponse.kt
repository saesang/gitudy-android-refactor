package com.takseha.data.source.remote.dto.profile.response


import com.google.gson.annotations.SerializedName

data class SocialInfoResponse(
    @SerializedName("blog_link")
    val blogLink: String?,
    @SerializedName("github_link")
    val githubLink: String?,
    @SerializedName("linked_in_link")
    val linkedInLink: String?
)