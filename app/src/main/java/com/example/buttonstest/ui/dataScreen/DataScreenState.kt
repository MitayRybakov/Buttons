package com.example.buttonstest.ui.dataScreen


sealed class DataScreenState {

    data class Data(val data: Int) : DataScreenState()
}
