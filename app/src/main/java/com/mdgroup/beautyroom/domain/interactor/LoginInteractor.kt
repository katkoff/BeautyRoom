package com.mdgroup.beautyroom.domain.interactor

import com.mdgroup.beautyroom.domain.gateway.LoginGateway
import com.mdgroup.beautyroom.domain.gateway.SessionGateway
import com.mdgroup.beautyroom.domain.model.LoginResult
import com.mdgroup.beautyroom.domain.model.ServerLoginResult
import com.mdgroup.beautyroom.domain.model.ServerSession

class LoginInteractor(
    private val loginGateway: LoginGateway,
    private val sessionGateway: SessionGateway
) {

    suspend fun login(login: String, password: String): LoginResult {
        val serverLoginResult = loginGateway.login(login, password)
        return when (serverLoginResult) {
            is ServerLoginResult.Success -> {
                sessionGateway.serverSession = ServerSession(serverLoginResult.token)
                LoginResult.Success
            }
            is ServerLoginResult.Error -> {
                LoginResult.Error(serverLoginResult.error.localizedMessage)
            }
        }
    }
}
