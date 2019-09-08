package com.mdgroup.beautyroom.di.modules

import com.mdgroup.beautyroom.ui.master.list.MasterListViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val mastersModule = module {
    viewModel { MasterListViewModel(get(), get(), get(), get()) }
}