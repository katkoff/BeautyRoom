package com.mdgroup.beautyroom

import android.app.Application
import com.chibatching.kotpref.Kotpref
import com.mdgroup.beautyroom.di.Di

class BeautyRoomApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        Kotpref.init(applicationContext)
        Di.init(applicationContext)
    }
}