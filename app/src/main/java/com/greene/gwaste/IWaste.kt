package com.greene.gwaste

import android.app.Application
import com.greene.gwaste.di.applicationModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class IWaste:Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger()
            androidContext(this@IWaste)
            modules(
                listOf(
                    applicationModule
                )
            )
        }
    }
}