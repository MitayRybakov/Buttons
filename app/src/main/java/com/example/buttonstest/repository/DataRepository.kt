package com.example.buttonstest.repository

import kotlinx.coroutines.flow.MutableStateFlow
import kotlin.random.Random.Default.nextInt

class DataRepository {
    val data = MutableStateFlow(value = 0)

    fun randomDataRepository() {
        data.value = nextInt(100)
    }
}


