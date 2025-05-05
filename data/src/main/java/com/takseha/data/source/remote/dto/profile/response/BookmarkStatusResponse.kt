package com.takseha.data.source.remote.dto.profile.response


import com.google.gson.annotations.SerializedName

data class BookmarkStatusResponse(
    @SerializedName("my_bookmark")
    val isBookmarked: Boolean
)