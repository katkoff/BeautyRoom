package com.mdgroup.beautyroom.ui.master.list

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mdgroup.beautyroom.data.api.ErrorHandler
import com.mdgroup.beautyroom.domain.interactor.MastersInteractor
import com.mdgroup.beautyroom.domain.interactor.SessionInteractor
import com.mdgroup.beautyroom.domain.model.Master
import com.mdgroup.beautyroom.navigation.MasterDetailsScreen
import com.mdgroup.beautyroom.navigation.SignInScreen
import com.mdgroup.beautyroom.ui.base.launchWithHandlers
import ru.terrakok.cicerone.Router
import timber.log.Timber

class MasterListViewModel(
    private val mastersInteractor: MastersInteractor,
    private val sessionInteractor: SessionInteractor,
    private val router: Router,
    private val errorHandler: ErrorHandler
) : ViewModel() {

    val masterList = MutableLiveData<List<Master>>()
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

    fun onMasterClicked(masterId: Int) {
        if (sessionInteractor.isSignedIn()) {
            router.navigateTo(MasterDetailsScreen(masterId))
        } else {
            router.navigateTo(SignInScreen())
        }
    }
}
