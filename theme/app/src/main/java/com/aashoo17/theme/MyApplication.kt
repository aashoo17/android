package com.aashoo17.theme

import android.app.Application
import androidx.appcompat.app.AppCompatDelegate

class MyApplication: Application() {
    override fun onCreate() {
        super.onCreate()
        //TODO: How can we give button to toggle on/off dark mode whe button clicked
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM)
    }
}