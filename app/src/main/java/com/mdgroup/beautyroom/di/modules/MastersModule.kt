package com.mdgroup.beautyroom.di.modules

import com.mdgroup.beautyroom.ui.master.details.MasterDetailsViewModel
import com.mdgroup.beautyroom.ui.master.list.MasterListViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val mastersModule = module {
    viewModel { MasterListViewModel(get(), get(), get(), get()) }
    viewModel { (masterId: String) ->
        MasterDetailsViewModel(
            router = get(),
            masterId = masterId)
    }
}