package com.mdgroup.beautyroom.ui.master.details

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mdgroup.beautyroom.data.api.ErrorHandler
import com.mdgroup.beautyroom.data.local.AppointmentState
import com.mdgroup.beautyroom.data.local.AppointmentStateHolder
import com.mdgroup.beautyroom.domain.interactor.MastersInteractor
import com.mdgroup.beautyroom.domain.model.Master
import com.mdgroup.beautyroom.navigation.ScheduleScreen
import com.mdgroup.beautyroom.ui.base.launchWithHandlers
import ru.terrakok.cicerone.Router
import timber.log.Timber

class MasterDetailsViewModel(
    private val errorHandler: ErrorHandler,
    private val mastersInteractor: MastersInteractor,
    private val router: Router,
    private val masterId: Int,
    private val appointmentStateHolder: AppointmentStateHolder
) : ViewModel() {

    val isProgress = MutableLiveData<Boolean>()
    val errorMessage = MutableLiveData<String>()
    val master = MutableLiveData<Master>()

    init {
        viewModelScope.launchWithHandlers(
            ::handleProgress,
            ::handleError
        ) {
            master.value = mastersInteractor.getMasterDetails(masterId)
            updateAppointmentState()
        }
    }

    private fun updateAppointmentState() {
        appointmentStateHolder.appointmentState = AppointmentState(
            master = master.value,
            service = null,
            appointmentDateTime = null
        )
    }

    private fun handleProgress(isProgress: Boolean) {
        this.isProgress.value = isProgress
    }

    private fun handleError(throwable: Throwable) {
        errorMessage.value = errorHandler.getErrorMessage(throwable)
        Timber.d(throwable)
    }

    fun onBackPressed() {
        router.exit()
    }

    fun onServiceClicked(masterId: Int, serviceName: String) {
      router.navigateTo(ScheduleScreen(masterId, serviceName))
    }
}