package com.mdgroup.beautyroom.di.modules

import com.mdgroup.beautyroom.ui.appointments.AppointmentsViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appointmentsModule = module {
    viewModel {
        AppointmentsViewModel(
            appointmentsInteractor = get(),
            router = get(),
            errorHandler = get()
        )
    }
}