package com.mdgroup.beautyroom.di

import android.content.Context
import com.mdgroup.beautyroom.di.modules.*
import org.koin.core.module.Module

fun allModules(appContext: Context): List<Module> = listOf(
    navigationModule,
    dataModule,

    domainModule,

    bottomNavigationModule,

    presentationModule(appContext),

    signInModule,
    signUpModule,

    mastersModule,

    scheduleViewModel
)