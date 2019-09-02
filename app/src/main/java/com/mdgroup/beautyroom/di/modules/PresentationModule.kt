package com.mdgroup.beautyroom.di.modules

import android.content.Context
import com.mdgroup.beautyroom.ui.ErrorHandler
import org.koin.dsl.module


fun presentationModule(appContext: Context) = module {
    single { appContext.resources }
    factory { ErrorHandler(get()) }
}