package com.example.codewarschallenge.mainapplication

import android.app.Application
import com.example.codewarschallenge.di.ApplicationComponent
import com.example.codewarschallenge.di.ApplicationModule
import com.example.codewarschallenge.di.DaggerApplicationComponent

class MainApplication: Application() {

    private lateinit var appComponent: ApplicationComponent
    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerApplicationComponent
            .builder()
            .applicationModule(ApplicationModule(this))
            .build()
    }

    fun getApplicationComponent() = appComponent
}