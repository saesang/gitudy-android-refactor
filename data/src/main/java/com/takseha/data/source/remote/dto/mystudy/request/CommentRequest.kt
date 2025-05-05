package com.takseha.data.source.remote.dto.mystudy.request


import com.google.gson.annotations.SerializedName

data class CommentRequest(
    @SerializedName("content")
    val comment: String
)