package com.mdgroup.beautyroom.di.modules

import com.mdgroup.beautyroom.data.local.AppointmentStateHolder
import com.mdgroup.beautyroom.domain.interactor.*
import org.koin.dsl.module

private val appointmentStateHolder = AppointmentStateHolder()

//TODO: Не уверен по поводу вынесения отдельного модуля Domain. Нужен ли? или лучше по фичам всё же.
// А то получается, сейчас много будет viewModel модулей, а домейн один с интеракторами...
val domainModule = module {
    single { appointmentStateHolder }

    factory { SessionInteractor() }
    factory { SignInInteractor(get(), get()) }
    factory { SignUpInteractor(get(), get()) }
    factory { MastersInteractor(get()) }
    factory { AppointmentsInteractor(get()) }
}