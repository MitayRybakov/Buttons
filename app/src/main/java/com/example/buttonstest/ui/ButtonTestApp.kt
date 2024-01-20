package com.example.buttonstest.ui

import android.app.Application
import com.example.buttonstest.repository.DataRepository

class ButtonTestApp : Application() {

    private lateinit var repository: DataRepository


    override fun onCreate() {
        super.onCreate()
        instance = this
        repository = DataRepository()
    }

    fun getRepository(): DataRepository = repository

    companion object {
        lateinit var instance: ButtonTestApp
            private set
    }
}