package com.example.userpostsjetpackcompose

import android.app.Application
import dagger.hilt.android.HiltAndroidApp
import javax.inject.Inject

@HiltAndroidApp
class BaseApplication(): Application() {

    override fun onCreate() {
        super.onCreate()
    }
}