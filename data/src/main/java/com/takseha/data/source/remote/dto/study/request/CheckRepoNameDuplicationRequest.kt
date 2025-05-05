package com.takseha.data.source.remote.dto.study.request


import com.google.gson.annotations.SerializedName

data class CheckRepoNameDuplicationRequest(
    @SerializedName("name")
    val name: String
)