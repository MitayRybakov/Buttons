package com.example.buttonstest.data.repository

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.runBlocking
import kotlin.random.Random.Default.nextInt

internal class DigitRepository {

    private val digitFlow = MutableStateFlow(value = 0)

    fun getFlow(): MutableStateFlow<Int> = digitFlow

    fun load() {
        runBlocking {
            while (true) {
                delay(2000L)
                val a = nextInt(100)
                digitFlow.tryEmit(a)
            }
        }
    }

    fun randomDataRepository() {
        digitFlow.value = nextInt(100)
    }
}


