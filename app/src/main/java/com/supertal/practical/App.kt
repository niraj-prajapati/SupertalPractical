package com.supertal.practical

import android.app.Application
import com.niraj.internetobserve.NetworkConnectivityObserver
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class App : Application() {
    override fun onCreate() {
        super.onCreate()
        //init network connectivity observer
        NetworkConnectivityObserver.init(this)
    }
}