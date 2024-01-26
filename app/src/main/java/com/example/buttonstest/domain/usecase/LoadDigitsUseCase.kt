package com.example.buttonstest.domain.usecase

import com.example.buttonstest.data.repository.DigitRepository

internal class LoadDigitsUseCase(
    private val repository: DigitRepository,
) {
    suspend operator fun invoke() {
        repository.load()
    }
}