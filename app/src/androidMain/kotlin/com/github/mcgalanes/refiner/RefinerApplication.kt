package com.github.mcgalanes.refiner

import android.app.Application
import com.github.mcgalanes.refiner.core.injection.initKoin
import org.koin.android.ext.koin.androidContext

class RefinerApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        initKoin {
            androidContext(this@RefinerApplication)
        }
    }
}