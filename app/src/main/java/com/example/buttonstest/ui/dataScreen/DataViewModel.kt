package com.example.buttonstest.ui.dataScreen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.buttonstest.ui.ButtonTestApp
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class DataViewModel : ViewModel() {

    private val repository = ButtonTestApp.instance.getRepository()

    private val _uiState = MutableStateFlow<DataScreenState>(DataScreenState.Data(repository.data.value))
    val uiState: StateFlow<DataScreenState> = _uiState.asStateFlow()

    fun randomData() {
        viewModelScope.launch {
            repository.randomDataRepository()
            delay((2000L))
            _uiState.value = DataScreenState.Data(repository.data.value)

        }
    }


}