package com.mdgroup.beautyroom.ui.signup

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mdgroup.beautyroom.domain.interactor.SignUpInteractor
import com.mdgroup.beautyroom.domain.model.UserRegInfo
import com.mdgroup.beautyroom.ui.ErrorHandler
import com.mdgroup.beautyroom.ui.base.launchWithHandlers
import ru.terrakok.cicerone.Router
import timber.log.Timber

class SignUpViewModel(
    private val signUpInteractor: SignUpInteractor,
    private val router: Router,
    private val errorHandler: ErrorHandler
) : ViewModel() {

    val errorMessage = MutableLiveData<String>()
    val isProgress = MutableLiveData<Boolean>()

    fun onSignUpClicked(userRegInfo: UserRegInfo) {
        viewModelScope.launchWithHandlers(
            ::handleProgress,
            ::handleError
        ) {
            signUpInteractor.signUp(userRegInfo)
            router.exit()
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