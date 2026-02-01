package com.aura.app

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class AuraApp : Application() {
    override fun onCreate() {
        super.onCreate()
    }
}
