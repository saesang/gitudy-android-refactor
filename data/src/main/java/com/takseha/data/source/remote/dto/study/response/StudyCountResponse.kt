package com.takseha.data.source.remote.dto.study.response

import com.google.gson.annotations.SerializedName

data class StudyCountResponse(
    @SerializedName("count")
    val count: Int
)
