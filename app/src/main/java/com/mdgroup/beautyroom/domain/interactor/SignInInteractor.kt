package com.mdgroup.beautyroom.domain.interactor

import com.mdgroup.beautyroom.domain.gateway.SessionGateway
import com.mdgroup.beautyroom.domain.gateway.SignInGateway
import com.mdgroup.beautyroom.domain.model.GenericResult
import com.mdgroup.beautyroom.domain.model.ServerSession
import com.mdgroup.beautyroom.domain.model.UserCredentials

class SignInInteractor(
    private val signInGateway: SignInGateway,
    private val sessionGateway: SessionGateway
) {

    suspend fun signIn(userCredentials: UserCredentials): GenericResult<Unit> {
        return signInGateway.signIn(userCredentials)
            .flatMap {
                sessionGateway.serverSession = ServerSession(it)
                GenericResult.empty()
            }
    }
}
