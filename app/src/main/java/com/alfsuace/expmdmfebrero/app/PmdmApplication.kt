package com.alfsuace.expmdmfebrero.app

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import org.koin.ksp.generated.module

class PmdmApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@PmdmApplication)
            modules(
                AppModule().module,

            )
        }
    }
}