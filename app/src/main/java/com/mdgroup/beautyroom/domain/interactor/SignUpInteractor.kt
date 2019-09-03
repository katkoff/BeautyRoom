package com.mdgroup.beautyroom.domain.interactor

import com.mdgroup.beautyroom.domain.gateway.SessionGateway
import com.mdgroup.beautyroom.domain.gateway.SignUpGateway
import com.mdgroup.beautyroom.domain.model.ServerSession
import com.mdgroup.beautyroom.domain.model.ServerSessionCredentials
import com.mdgroup.beautyroom.domain.model.UserRegInfo

class SignUpInteractor(
    private val signUpGateway: SignUpGateway,
    private val sessionGateway: SessionGateway
) {

    suspend fun signUp(userRegInfo: UserRegInfo): ServerSessionCredentials {
        return signUpGateway.signUp(userRegInfo)
    }

    fun saveToken(serverSessionCredentials: ServerSessionCredentials) {
        sessionGateway.serverSession = ServerSession(serverSessionCredentials)
    }
}
