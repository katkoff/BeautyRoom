package com.mdgroup.beautyroom.ui.signin

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mdgroup.beautyroom.domain.interactor.SignInInteractor
import com.mdgroup.beautyroom.domain.model.LoginResult
import kotlinx.coroutines.launch
import ru.terrakok.cicerone.Router

class SignInViewModel(
    private val signInInteractor: SignInInteractor,
    private val router: Router
) : ViewModel() {

    suspend fun login(login: String, password: String) {
        viewModelScope.launch {
            val loginResult = signInInteractor.login(login, password)
            when (loginResult) {
                LoginResult.Success -> {
                    // todo call router

                    Log.d("SignInViewModel", "Success")
                }
                is LoginResult.Error -> {
                    Log.d("SignInViewModel", "Error " + loginResult.message)
                }
            }
        }
    }
}