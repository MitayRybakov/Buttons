package com.example.buttonstest.domain.usecase

import com.example.buttonstest.data.repository.DigitRepository
import com.example.buttonstest.domain.model.Digit
import kotlinx.coroutines.flow.StateFlow

internal class GetDigitsUseCase(
    private val repository: DigitRepository,
) {
    operator fun invoke(): StateFlow<Digit> =
        repository.getFlow()
}