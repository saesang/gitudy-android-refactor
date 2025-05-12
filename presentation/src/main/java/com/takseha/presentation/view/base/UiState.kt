package com.takseha.presentation.view.base

import com.takseha.domain.model.common.Failure

sealed class UiState<out T>

data object Init : UiState<Nothing>()
data object Loading : UiState<Nothing>()
data class Success<out T>(val data: T) : UiState<T>()
data class Error(val message: String, val failure: Failure? = null) : UiState<Nothing>()