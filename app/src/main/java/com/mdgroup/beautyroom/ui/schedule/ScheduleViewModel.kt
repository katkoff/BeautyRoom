package com.mdgroup.beautyroom.ui.schedule

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mdgroup.beautyroom.data.api.ErrorHandler
import com.mdgroup.beautyroom.domain.interactor.SessionInteractor
import com.mdgroup.beautyroom.domain.model.TimeBlock
import com.mdgroup.beautyroom.ui.base.launchWithHandlers
import org.threeten.bp.LocalDate
import org.threeten.bp.LocalDateTime
import ru.terrakok.cicerone.Router
import timber.log.Timber

class ScheduleViewModel(
    private val sessionInteractor: SessionInteractor,
    private val router: Router,
    private val errorHandler: ErrorHandler,
    private val masterId: Int
) : ViewModel() {

    val errorMessage = MutableLiveData<String>()
    val isProgress = MutableLiveData<Boolean>()
    val timeBlockList = MutableLiveData<List<TimeBlock>>()

    val clickedDate = MutableLiveData<LocalDate>()

    fun loadSchedule() {
        viewModelScope.launchWithHandlers(
            ::handleProgress,
            ::handleError
        ) {
            timeBlockList.value = listOf(
                TimeBlock(LocalDateTime.now(), 60, true),
                TimeBlock(LocalDateTime.now(), 60, false),
                TimeBlock(LocalDateTime.now(), 60, true),
                TimeBlock(LocalDateTime.now(), 60, true),
                TimeBlock(LocalDateTime.now(), 60, false),
                TimeBlock(LocalDateTime.now(), 60, false),
                TimeBlock(LocalDateTime.now(), 60, true)
            )
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
//        val instantClicked  = Instant.ofEpochMilli(instantMillisecondsClicked)
//        val systemDefaultZoneId = ZoneId.systemDefault()
//        val localDate = instantClicked.atZone(systemDefaultZoneId).toLocalDate()

        clickedDate.value = localDateClicked
    }
}