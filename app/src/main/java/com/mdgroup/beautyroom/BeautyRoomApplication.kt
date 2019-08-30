package com.mdgroup.beautyroom

import android.app.Application
import com.chibatching.kotpref.Kotpref
import com.mdgroup.beautyroom.di.modules
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class BeautyRoomApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        initDi()
        Kotpref.init(applicationContext)
    }

    private fun initDi() = startKoin {
        androidContext(this@BeautyRoomApplication)
        modules(modules)
    }
}