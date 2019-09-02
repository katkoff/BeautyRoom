package com.mdgroup.beautyroom.di.modules

import com.mdgroup.beautyroom.domain.interactor.MastersInteractor
import com.mdgroup.beautyroom.domain.interactor.SignInInteractor
import org.koin.dsl.module

// todo: Не уверен по поводу вынесения отдельного модуля Domain. Нужен ли? или лучше по фичам всё же.
// А то получается, сейчас много будет viewModel модулей, а домейн один с интеракторами...
val domainModule = module {

    factory { SignInInteractor(get(), get()) }
    factory { MastersInteractor(get()) }
}