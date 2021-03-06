package com.ablazim.oneaviationandroid

import android.app.Application
import com.ablazim.oneaviationandroid.main.MainModule
import com.ablazim.oneaviationandroid.splash.SplashModule
import com.ablazim.oneaviationandroid.trips.TripsModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@App)
            modules(
                TripsModule.create(),
                SplashModule.create(),
                MainModule.create()
            )
        }
    }
}