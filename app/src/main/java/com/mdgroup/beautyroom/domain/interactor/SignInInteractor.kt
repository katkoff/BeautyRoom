package com.mdgroup.beautyroom.domain.interactor

import com.mdgroup.beautyroom.domain.gateway.SessionGateway
import com.mdgroup.beautyroom.domain.gateway.SignInGateway
import com.mdgroup.beautyroom.domain.model.ServerSession
import com.mdgroup.beautyroom.domain.model.ServerSignInResult
import com.mdgroup.beautyroom.domain.model.SignIn
import com.mdgroup.beautyroom.domain.model.SignInResult

class SignInInteractor(
    private val signInGateway: SignInGateway,
    private val sessionGateway: SessionGateway
) {

    suspend fun signIn(signIn: SignIn): SignInResult {
        val serverLoginResult = signInGateway.signIn(signIn)
        return when (serverLoginResult) {
            is ServerSignInResult.Success -> {
                sessionGateway.serverSession = ServerSession(serverLoginResult.token)
                SignInResult.Success
            }
            is ServerSignInResult.Error -> {
                SignInResult.Error(serverLoginResult.error.localizedMessage)
            }
        }
    }
}
