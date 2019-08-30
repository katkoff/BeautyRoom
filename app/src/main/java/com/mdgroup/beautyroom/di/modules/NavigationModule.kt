package com.mdgroup.beautyroom.di.modules

import org.koin.dsl.module
import ru.terrakok.cicerone.Cicerone

private val cicerone = Cicerone.create()

val navigationModule = module {
    single { cicerone }
    single { cicerone.navigatorHolder }
    single { cicerone.router }
}