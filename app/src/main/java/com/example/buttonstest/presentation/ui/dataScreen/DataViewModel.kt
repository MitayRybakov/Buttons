package com.example.buttonstest.presentation.ui.dataScreen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.buttonstest.domain.usecase.GetDigitsUseCase
import com.example.buttonstest.domain.usecase.LoadDigitsUseCase
import com.example.buttonstest.ButtonsTestApp
import com.example.buttonstest.domain.model.Digit
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class DataViewModel : ViewModel() {

    private val getDigitsUseCase = GetDigitsUseCase(ButtonsTestApp.instance.getRepository())

    private val initialDigit = Digit(0)

    private val _uiState = MutableStateFlow<DataScreenState>(DataScreenState.Data(initialDigit))
    val uiState: StateFlow<DataScreenState> = _uiState.asStateFlow()

    init {
        viewModelScope.launch {
            getDigitsUseCase().collect { digit ->
                _uiState.value = DataScreenState.Data(digit)
            }
        }
    }
}