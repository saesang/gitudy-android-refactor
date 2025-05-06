package com.takseha.domain.model.mystudy

enum class TodoStatus {
    TODO_INCOMPLETE, TODO_COMPLETE, TODO_OVERDUE;

    companion object {
        fun from(value: String): TodoStatus =
            TodoStatus.entries.find { it.name.equals(value, ignoreCase = true) }
                ?: TODO_INCOMPLETE // 기본값
    }
}