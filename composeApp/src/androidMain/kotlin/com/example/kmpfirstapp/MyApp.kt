package com.example.kmpfirstapp

import android.app.Application
import com.example.kmpfirstapp.di.initKoin
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger

class MyApp: Application() {

    override fun onCreate() {
        super.onCreate()
        initKoin {
            androidContext(this@MyApp)
            androidLogger()
            modules()
        }
    }
}