package com.mdgroup.beautyroom.di.modules

import com.mdgroup.beautyroom.ui.signin.SignInViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val signInModule = module {
    viewModel { SignInViewModel(get(), get(), get()) }
}