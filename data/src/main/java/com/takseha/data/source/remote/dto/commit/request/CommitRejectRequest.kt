package com.takseha.data.source.remote.dto.commit.request


import com.google.gson.annotations.SerializedName

data class CommitRejectRequest(
    @SerializedName("rejection_reason")
    val rejectionReason: String
)