package com.mdgroup.beautyroom.data.stub

import com.mdgroup.beautyroom.domain.gateway.SignInGateway
import com.mdgroup.beautyroom.domain.model.ServerSignInResult

class StubSignInGateway : SignInGateway {

    override suspend fun signIn(login: String, password: String): ServerSignInResult {
        return ServerSignInResult.Success("stub-token")
    }
}