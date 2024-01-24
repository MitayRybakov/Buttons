package com.example.buttonstest.domain.usecase

import com.example.buttonstest.data.repository.DigitRepository
import com.example.buttonstest.domain.model.Digit
import kotlinx.coroutines.flow.SharedFlow

internal class GetDigitsUseCase(
    private val repository : DigitRepository,
) {
    operator fun invoke() : SharedFlow<Int> = repository.getFlow()
}