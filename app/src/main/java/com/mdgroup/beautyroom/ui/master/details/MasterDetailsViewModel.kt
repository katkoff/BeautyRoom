package com.mdgroup.beautyroom.ui.master.details

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mdgroup.beautyroom.data.api.ErrorHandler
import com.mdgroup.beautyroom.domain.interactor.MastersInteractor
import com.mdgroup.beautyroom.domain.model.Master
import com.mdgroup.beautyroom.ui.base.launchWithHandlers
import ru.terrakok.cicerone.Router
import timber.log.Timber

class MasterDetailsViewModel(
    private val errorHandler: ErrorHandler,
    private val mastersInteractor: MastersInteractor,
    private val router: Router,
    private val masterId: Int
) : ViewModel() {

    val isProgress = MutableLiveData<Boolean>()
    val errorMessage = MutableLiveData<String>()
    val master = MutableLiveData<Master>()

    //TODO: remove after implement schedule
    val onClickMessage = MutableLiveData<String>()

    init {
        viewModelScope.launchWithHandlers(
            ::handleProgress,
            ::handleError
        ) {
            master.value = mastersInteractor.getMasterDetails(masterId)
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

    fun onServiceClicked(serviceId: Int) {
        onClickMessage.value = "You click on service with $serviceId id! Well done :)"
    }
}