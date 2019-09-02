package com.mdgroup.beautyroom.ui.masters

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mdgroup.beautyroom.domain.interactor.MastersInteractor
import com.mdgroup.beautyroom.domain.model.MasterModel
import com.mdgroup.beautyroom.ui.ErrorHandler
import com.mdgroup.beautyroom.ui.base.launchWithHandlers
import ru.terrakok.cicerone.Router
import timber.log.Timber

class MasterListViewModel(
    private val mastersInteractor: MastersInteractor,
    private val router: Router,
    private val errorHandler: ErrorHandler
) : ViewModel() {

    val masterList = MutableLiveData<List<MasterModel>>()
    val errorMessage = MutableLiveData<String>()
    val isProgress = MutableLiveData<Boolean>()

    fun loadMasterList() {
        viewModelScope.launchWithHandlers(
            ::handleProgress,
            ::handleError
        ) {
            masterList.value = mastersInteractor.getMasters()
        }
    }

    private fun handleProgress(isProgress: Boolean) {
        this.isProgress.value = isProgress
    }

    private fun handleError(throwable: Throwable) {
        errorMessage.value = errorHandler.getErrorMessage(throwable)
        Timber.d(throwable)
    }
}
