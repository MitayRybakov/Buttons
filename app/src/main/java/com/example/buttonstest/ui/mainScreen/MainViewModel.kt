package com.example.buttonstest.ui.mainScreen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.buttonstest.ui.ButtonTestApp
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {

    private val  repository = ButtonTestApp.instance.getRepository()

    private val _uiState = MutableStateFlow<ScreenState>(ScreenState.Initial("Начальный"))
    val uiState: StateFlow<ScreenState> = _uiState.asStateFlow()

    fun loadInfo() {
        _uiState.value = ScreenState.Loading

        viewModelScope.launch {
            delay(5000L)
            _uiState.value = ScreenState.Success("Успех")
        }
    }

    fun sendInfo() {
        _uiState.value = ScreenState.Loading

        viewModelScope.launch {
            delay(5000L)
            _uiState.value = ScreenState.Error("Ошибка")
        }
    }

    fun randomData() {
        viewModelScope.launch {
            repository.randomDataRepository()
        }
    }
}
