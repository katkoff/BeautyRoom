package com.mdgroup.beautyroom.ui.appointments

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mdgroup.beautyroom.data.api.ErrorHandler
import com.mdgroup.beautyroom.domain.interactor.AppointmentsInteractor
import com.mdgroup.beautyroom.domain.model.Appointment
import com.mdgroup.beautyroom.ui.base.launchWithHandlers
import ru.terrakok.cicerone.Router
import timber.log.Timber

class AppointmentsViewModel(
    private val appointmentsInteractor: AppointmentsInteractor,
    private val router: Router,
    private val errorHandler: ErrorHandler
) : ViewModel() {

    val appointmentList = MutableLiveData<List<Appointment>>()
    val errorMessage = MutableLiveData<String>()
    val isProgress = MutableLiveData<Boolean>()

    fun loadAppointments() {
        viewModelScope.launchWithHandlers(
            ::handleProgress,
            ::handleError
        ) {
            appointmentList.value = appointmentsInteractor.getAppointments()
        }
    }

    fun onRefresh() {
        loadAppointments()
    }

    private fun handleProgress(isProgress: Boolean) {
        this.isProgress.value = isProgress
    }

    private fun handleError(throwable: Throwable) {
        errorMessage.value = errorHandler.getErrorMessage(throwable)
        Timber.d(throwable)
    }
}