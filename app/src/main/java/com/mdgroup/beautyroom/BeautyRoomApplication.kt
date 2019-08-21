package com.mdgroup.beautyroom

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import org.koin.core.module.Module
import org.koin.dsl.module
import ru.terrakok.cicerone.Cicerone

class BeautyRoomApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        val cicerone = Cicerone.create()
        val navigationModule = module {
            single { cicerone }
            single { cicerone.navigatorHolder }
            single { cicerone.router }
        }

        startKoin {
            androidContext(this@BeautyRoomApplication)
            modules(navigationModule)
        }


    }
}