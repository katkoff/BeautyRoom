package com.mdgroup.beautyroom.ui.signin

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mdgroup.beautyroom.domain.interactor.SignInInteractor
import com.mdgroup.beautyroom.domain.model.GenericResult
import com.mdgroup.beautyroom.domain.model.UserCredentials
import com.mdgroup.beautyroom.navigation.MastersScreen
import com.mdgroup.beautyroom.navigation.SignUpScreen
import kotlinx.coroutines.launch
import ru.terrakok.cicerone.Router

class SignInViewModel(
    private val signInInteractor: SignInInteractor,
    private val router: Router
) : ViewModel() {

    val errorMessage: MutableLiveData<String> = MutableLiveData()

    suspend fun onSignInClicked(userCredentials: UserCredentials) {
        viewModelScope.launch {
            val signInResult = signInInteractor.signIn(userCredentials)
            when (signInResult) {
                is GenericResult.Success -> {
                    router.replaceScreen(MastersScreen())
                    Log.d("SignInViewModel", "Success")
                }
                is GenericResult.Error -> {
                    errorMessage.value = signInResult.throwable.message
                    Log.d("SignInViewModel", "Error " + signInResult.throwable.message)
                }
            }
        }
    }

    fun onSignUpClicked() = router.navigateTo(SignUpScreen())
}