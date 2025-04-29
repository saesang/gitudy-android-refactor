package com.takseha.domain.model.commit

import com.takseha.domain.model.todo.CommitSummary

data class CommitDetail(
    val basicInfo: CommitSummary,
    val commitSha: String
)
