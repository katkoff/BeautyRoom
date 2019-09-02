package com.mdgroup.beautyroom

import android.app.Application
import com.chibatching.kotpref.Kotpref
import com.mdgroup.beautyroom.di.allModules
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import timber.log.Timber

class BeautyRoomApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
        initDi()
        Kotpref.init(applicationContext)
    }

    private fun initDi() = startKoin {
        androidContext(this@BeautyRoomApplication)
        modules(allModules(applicationContext))
    }
}