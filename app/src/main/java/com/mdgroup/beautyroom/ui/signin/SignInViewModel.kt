package com.mdgroup.beautyroom.ui.signin

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mdgroup.beautyroom.data.api.ErrorHandler
import com.mdgroup.beautyroom.domain.interactor.SignInInteractor
import com.mdgroup.beautyroom.domain.model.UserCredentials
import com.mdgroup.beautyroom.navigation.SignUpScreen
import com.mdgroup.beautyroom.ui.base.launchWithHandlers
import ru.terrakok.cicerone.Router
import ru.terrakok.cicerone.android.support.SupportAppScreen
import timber.log.Timber

class SignInViewModel(
    private val signInInteractor: SignInInteractor,
    private val router: Router,
    private val errorHandler: ErrorHandler
) : ViewModel() {

    val isProgress = MutableLiveData<Boolean>()
    val errorMessage = MutableLiveData<String>()

    private var phone = ""

    fun onSignInClicked(password: String, nextScreen: SupportAppScreen) {
        viewModelScope.launchWithHandlers(
            progressHandler = ::handleProgress,
            errorHandler = ::handleError
        ) {

            signInInteractor.signIn(assembleUserCredentials(password))
            router.newRootScreen(nextScreen)
        }
    }

    private fun assembleUserCredentials(password: String) = UserCredentials(
        phone = "8$phone", //TODO: change to "7" after fix on server
        password = password
    )

    fun onSignUpClicked() {
        router.navigateTo(SignUpScreen())
    }

    fun onPhoneChanged(phoneExtractedValue: String) {
        phone = phoneExtractedValue
    }

    private fun handleError(throwable: Throwable) {
        errorMessage.value = errorHandler.getErrorMessage(throwable)
        Timber.d(throwable)
    }

    private fun handleProgress(isProgress: Boolean) {
        this.isProgress.value = isProgress
    }
}
