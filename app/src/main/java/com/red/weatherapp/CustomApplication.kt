package com.red.weatherapp

import android.app.Application
import com.red.weatherapp.di.weatherApp
import org.koin.android.ext.android.startKoin

class CustomApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        initKoinModules()
    }

    private fun initKoinModules() {
        /**
         * Start Koin context
         * */
        startKoin(this, weatherApp)
    }

}