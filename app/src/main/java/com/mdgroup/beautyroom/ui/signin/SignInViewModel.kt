package com.mdgroup.beautyroom.ui.signin

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mdgroup.beautyroom.domain.interactor.SignInInteractor
import com.mdgroup.beautyroom.domain.model.SignIn
import com.mdgroup.beautyroom.domain.model.SignInResult
import com.mdgroup.beautyroom.navigation.SignUpScreen
import kotlinx.coroutines.launch
import ru.terrakok.cicerone.Router

class SignInViewModel(
    private val signInInteractor: SignInInteractor,
    private val router: Router
) : ViewModel() {

    suspend fun onSignInClicked(signIn: SignIn) {
        viewModelScope.launch {
            val signIn = signInInteractor.signIn(signIn)
            when (signIn) {
                SignInResult.Success -> {
                    // todo call router

                    Log.d("SignInViewModel", "Success")
                }
                is SignInResult.Error -> {
                    Log.d("SignInViewModel", "Error " + signIn.message)
                }
            }
        }
    }

    fun signUp() = router.navigateTo(SignUpScreen())
}