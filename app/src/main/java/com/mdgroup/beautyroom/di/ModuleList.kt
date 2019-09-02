package com.mdgroup.beautyroom.di

import com.mdgroup.beautyroom.di.modules.*

val modules = listOf(
    navigationModule,
    dataModule,

    domainModule,

    signInModule,
    signUpModule,

    mastersModule
)