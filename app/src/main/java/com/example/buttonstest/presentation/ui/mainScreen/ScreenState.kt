package com.example.buttonstest.presentation.ui.mainScreen

sealed class ScreenState {
    data object Loading : ScreenState()

    data class Initial(val text: String) : ScreenState()

    data class Error(val text: String) : ScreenState()

    data class Success(val text: String) : ScreenState()

}