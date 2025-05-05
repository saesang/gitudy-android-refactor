package com.takseha.data.source.remote.dto.study.response


import com.google.gson.annotations.SerializedName

data class StudyRankResponse(
    @SerializedName("ranking")
    val rank: Int,
    @SerializedName("score")
    val score: Int
)