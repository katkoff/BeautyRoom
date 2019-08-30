package com.mdgroup.beautyroom.data.stub

import com.mdgroup.beautyroom.domain.gateway.SignInGateway
import com.mdgroup.beautyroom.domain.model.ServerSignInResult
import com.mdgroup.beautyroom.domain.model.SignIn

class StubSignInGateway : SignInGateway {

    override suspend fun signIn(signIn: SignIn): ServerSignInResult {
        return ServerSignInResult.Success("stub-token")
    }
}