package com.mdgroup.beautyroom.di.modules

import com.mdgroup.beautyroom.ui.master.details.MasterDetailsViewModel
import com.mdgroup.beautyroom.ui.master.list.MasterListViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val mastersModule = module {
    viewModel {
        MasterListViewModel(
            mastersInteractor = get(),
            sessionInteractor = get(),
            router = get(),
            errorHandler = get()
        )
    }

    viewModel { (masterId: String) ->
        MasterDetailsViewModel(
            errorHandler = get(),
            mastersInteractor = get(),
            router = get(),
            masterId = masterId
        )
    }
}