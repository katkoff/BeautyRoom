package com.mdgroup.beautyroom.di.moduls

import com.mdgroup.beautyroom.ui.signin.SignInViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val signInModule = module {
    viewModel { SignInViewModel(get(), get()) }
}