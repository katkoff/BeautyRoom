package com.mdgroup.beautyroom.di.moduls

import com.mdgroup.beautyroom.ui.signup.SignUpViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val signUpModule = module {
    viewModel { SignUpViewModel() }
}