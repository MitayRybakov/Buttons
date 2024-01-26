package com.example.buttonstest.presentation.ui.mainScreen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.buttonstest.domain.usecase.GetDigitsUseCase
import com.example.buttonstest.domain.usecase.LoadDigitsUseCase
import com.example.buttonstest.ButtonsTestApp
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {

    private val getDigitsUseCase = GetDigitsUseCase(ButtonsTestApp.instance.getRepository())
    private val loadDigitsUseCase = LoadDigitsUseCase(ButtonsTestApp.instance.getRepository())

    private val _uiState = MutableStateFlow<ScreenState>(ScreenState.Initial("Начальный"))
    val uiState: StateFlow<ScreenState> = _uiState.asStateFlow()

    fun setSuccessState() {
        _uiState.value = ScreenState.Loading

        viewModelScope.launch {
            delay(5000L)
            _uiState.value = ScreenState.Success("Успех")
        }
    }

    fun setErrorState() {
        _uiState.value = ScreenState.Loading

        viewModelScope.launch {
            delay(5000L)
            _uiState.value = ScreenState.Error("Ошибка")
        }
    }

    fun generateDigit() {
        viewModelScope.launch {
            loadDigitsUseCase()
        }
    }
}
