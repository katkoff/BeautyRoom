package com.mdgroup.beautyroom.di

import android.content.Context
import com.mdgroup.beautyroom.di.modules.*
import org.koin.core.module.Module

fun allModules(appContext: Context): List<Module> = listOf(
    navigationModule,
    dataModule,

    domainModule,

    signInModule,
    signUpModule,

    bottomNavigationModule,

    mastersModule,
    presentationModule(appContext)
)