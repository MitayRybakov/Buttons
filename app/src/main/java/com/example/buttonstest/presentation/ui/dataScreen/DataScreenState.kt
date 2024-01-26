package com.example.buttonstest.presentation.ui.dataScreen

import com.example.buttonstest.domain.model.Digit


sealed class DataScreenState {

    data class Data(val data: Digit) : DataScreenState()
}
