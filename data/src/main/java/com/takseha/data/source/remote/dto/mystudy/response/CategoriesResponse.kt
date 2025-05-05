package com.takseha.data.source.remote.dto.mystudy.response


import com.google.gson.annotations.SerializedName
import com.takseha.data.source.remote.dto.study.response.CategoryResponse

data class CategoriesResponse(
    @SerializedName("category_response_list")
    val categoryResponseList: List<CategoryResponse>,
    @SerializedName("cursor_idx")
    val cursorIdx: Long?
)