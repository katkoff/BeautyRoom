package com.mdgroup.beautyroom.ui.master.schedule

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mdgroup.beautyroom.data.api.ErrorHandler
import com.mdgroup.beautyroom.data.local.AppointmentState
import com.mdgroup.beautyroom.data.local.AppointmentStateHolder
import com.mdgroup.beautyroom.domain.interactor.MastersInteractor
import com.mdgroup.beautyroom.domain.model.TimeBlock
import com.mdgroup.beautyroom.ui.base.SingleLiveEvent
import com.mdgroup.beautyroom.ui.base.launchWithHandlers
import org.threeten.bp.LocalDate
import ru.terrakok.cicerone.Router
import timber.log.Timber

class ScheduleViewModel(
    private val mastersInteractor: MastersInteractor,
    private val router: Router,
    private val errorHandler: ErrorHandler,
    private val masterId: Int,
    private val appointmentStateHolder: AppointmentStateHolder
) : ViewModel() {

    val errorMessage = MutableLiveData<String>()
    val isProgress = MutableLiveData<Boolean>()
    val timeBlockList = MutableLiveData<List<TimeBlock>>()
    val appointmentAlert = SingleLiveEvent<AppointmentState>()

    fun loadSchedule() {
        viewModelScope.launchWithHandlers(
            ::handleProgress,
            ::handleError
        ) {
            timeBlockList.value = mastersInteractor.getMasterScheduleByDate(
                masterId,
                LocalDate.now()
            )

            updateAppointmentState(LocalDate.now())
        }
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

    fun onDateChangeClicked(localDateClicked: LocalDate) {
        viewModelScope.launchWithHandlers(
            ::handleProgress,
            ::handleError
        ) {
            timeBlockList.value = mastersInteractor.getMasterScheduleByDate(
                masterId,
                localDateClicked
            )

            updateAppointmentState(localDateClicked)
        }
    }

    fun onTimeBlockClicked(timeBlock: TimeBlock) {
        val finallyAppointmentState =
            appointmentStateHolder.appointmentState!!.copy(appointmentTime = timeBlock.startTime)
        appointmentStateHolder.appointmentState = finallyAppointmentState
        appointmentAlert.value = finallyAppointmentState
    }

    private fun updateAppointmentState(localDate: LocalDate) {
        val updatedAppointmentState = appointmentStateHolder.appointmentState!!.copy(appointmentDate = localDate)
        appointmentStateHolder.appointmentState = updatedAppointmentState
    }
}