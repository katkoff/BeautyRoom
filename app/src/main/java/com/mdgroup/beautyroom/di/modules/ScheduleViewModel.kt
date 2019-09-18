package com.mdgroup.beautyroom.di.modules

import com.mdgroup.beautyroom.ui.schedule.ScheduleViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val scheduleViewModel = module {
    viewModel {
        ScheduleViewModel(
            sessionInteractor = get(),
            router = get(),
            errorHandler = get()
        )
    }
}