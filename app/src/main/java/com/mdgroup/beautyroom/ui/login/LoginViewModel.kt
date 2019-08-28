package com.mdgroup.beautyroom.ui.login

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mdgroup.beautyroom.domain.interactor.LoginInteractor
import com.mdgroup.beautyroom.domain.model.LoginResult
import kotlinx.coroutines.launch
import ru.terrakok.cicerone.Router

class LoginViewModel(
    private val loginInteractor: LoginInteractor,
    private val router: Router
) : ViewModel() {

    suspend fun login(login: String, password: String) {
        viewModelScope.launch {
            val loginResult = loginInteractor.login(login, password)
            when (loginResult) {
                LoginResult.Success -> {
                    // todo call router

                    Log.d("LoginViewModel", "Success")
                }
                is LoginResult.Error -> {
                    Log.d("LoginViewModel", "Error " + loginResult.message)
                }
            }
        }
    }
}