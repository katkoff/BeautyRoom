package com.mdgroup.beautyroom.di.modules

import com.mdgroup.beautyroom.ui.masters.MasterListViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val mastersModule = module {
    viewModel { MasterListViewModel(get(), get(), get()) }
}