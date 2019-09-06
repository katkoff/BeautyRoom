package com.mdgroup.beautyroom.ui.signin

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mdgroup.beautyroom.domain.interactor.SignInInteractor
import com.mdgroup.beautyroom.domain.model.UserCredentials
import com.mdgroup.beautyroom.navigation.MasterListScreen
import com.mdgroup.beautyroom.navigation.SignUpScreen
import com.mdgroup.beautyroom.ui.ErrorHandler
import com.mdgroup.beautyroom.ui.base.launchWithHandlers
import ru.terrakok.cicerone.Router
import timber.log.Timber

class SignInViewModel(
    private val signInInteractor: SignInInteractor,
    private val router: Router,
    private val errorHandler: ErrorHandler
) : ViewModel() {

    val errorMessage = MutableLiveData<String>()

    fun onSignInClicked(userCredentials: UserCredentials) {
        viewModelScope.launchWithHandlers(
            errorHandler = ::handleError
        ) {
            signInInteractor.signIn(userCredentials)
            router.replaceScreen(MasterListScreen())
        }
    }

    private fun handleError(throwable: Throwable) {
        errorMessage.value = errorHandler.getErrorMessage(throwable)
        Timber.d(throwable)
    }

    fun onSignUpClicked() {
        router.navigateTo(SignUpScreen())
    }
}
