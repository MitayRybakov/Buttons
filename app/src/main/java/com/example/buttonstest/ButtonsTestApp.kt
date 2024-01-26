package com.example.buttonstest

import android.app.Application
import com.example.buttonstest.data.repository.DigitRepository

class ButtonsTestApp : Application() {

    private lateinit var repository: DigitRepository

    override fun onCreate() {
        super.onCreate()
        instance = this
        repository = DigitRepository()
    }

    internal fun getRepository(): DigitRepository = repository

    companion object {
        lateinit var instance: ButtonsTestApp
            private set
    }
}