package com.davidodari.splashy

import android.app.Application
import timber.log.Timber

/**
 * Created By David Odari
 * On 24/08/19
 *
 **/
class SplashyApplication:Application() {
    override fun onCreate() {
        super.onCreate()
        Timber.plant(Timber.DebugTree())
    }
}