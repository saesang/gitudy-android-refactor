package com.takseha.data.source.remote.dto.study.response


import com.google.gson.annotations.SerializedName

data class CategoryResponse(
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String
)