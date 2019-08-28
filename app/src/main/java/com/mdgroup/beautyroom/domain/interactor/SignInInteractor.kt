package com.mdgroup.beautyroom.domain.interactor

import com.mdgroup.beautyroom.domain.gateway.SessionGateway
import com.mdgroup.beautyroom.domain.gateway.SignInGateway
import com.mdgroup.beautyroom.domain.model.LoginResult
import com.mdgroup.beautyroom.domain.model.ServerSession
import com.mdgroup.beautyroom.domain.model.ServerSignInResult

class SignInInteractor(
    private val signInGateway: SignInGateway,
    private val sessionGateway: SessionGateway
) {

    suspend fun login(login: String, password: String): LoginResult {
        val serverLoginResult = signInGateway.signIn(login, password)
        return when (serverLoginResult) {
            is ServerSignInResult.Success -> {
                sessionGateway.serverSession = ServerSession(serverLoginResult.token)
                LoginResult.Success
            }
            is ServerSignInResult.Error -> {
                LoginResult.Error(serverLoginResult.error.localizedMessage)
            }
        }
    }
}
