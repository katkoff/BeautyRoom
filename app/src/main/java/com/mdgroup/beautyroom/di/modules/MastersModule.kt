package com.mdgroup.beautyroom.di.modules

import com.mdgroup.beautyroom.ui.masters.MastersViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val mastersModule = module {
    viewModel { MastersViewModel(get(), get()) }
}