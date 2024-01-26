package com.example.buttonstest.data.repository

import com.example.buttonstest.domain.model.Digit
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext
import kotlin.random.Random.Default.nextInt

internal class DigitRepository {

    private val digitFlow = MutableStateFlow(Digit(0))

    fun getFlow(): MutableStateFlow<Digit> = digitFlow

    suspend fun load() {
        withContext(Dispatchers.IO) {
            var i = 0
            while (i < 50) {
                val a = Digit(nextInt(100))
                digitFlow.emit(a)
                delay(2000L)
                i++
            }
        }
    }
}


