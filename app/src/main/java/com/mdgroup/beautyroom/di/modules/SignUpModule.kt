package com.mdgroup.beautyroom.di.modules

import com.mdgroup.beautyroom.ui.signup.SignUpViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val signUpModule = module {
    viewModel { SignUpViewModel(get(), get(), get()) }
}