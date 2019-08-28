package com.mdgroup.beautyroom.data.api

import com.mdgroup.beautyroom.domain.gateway.SignInGateway
import com.mdgroup.beautyroom.domain.model.ServerSignInResult

class ApiSignInGateway : SignInGateway {

    override suspend fun signIn(login: String, password: String): ServerSignInResult {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}