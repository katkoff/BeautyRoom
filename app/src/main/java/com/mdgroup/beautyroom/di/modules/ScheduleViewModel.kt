package com.mdgroup.beautyroom.di.modules

import com.mdgroup.beautyroom.ui.master.schedule.ScheduleViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val scheduleViewModel = module {
    viewModel {(masterId: Int) ->
        ScheduleViewModel(
            mastersInteractor = get(),
            appointmentsInteractor = get(),
            sessionInteractor = get(),
            router = get(),
            errorHandler = get(),
            masterId = masterId,
            appointmentStateHolder = get()
        )
    }
}