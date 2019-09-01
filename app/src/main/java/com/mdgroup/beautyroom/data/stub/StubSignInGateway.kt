package com.mdgroup.beautyroom.data.stub

import com.mdgroup.beautyroom.domain.gateway.SignInGateway
import com.mdgroup.beautyroom.domain.model.GenericResult
import com.mdgroup.beautyroom.domain.model.ServerSessionCredentials
import com.mdgroup.beautyroom.domain.model.UserCredentials

class StubSignInGateway : SignInGateway {

    override suspend fun signIn(userCredentials: UserCredentials): GenericResult<ServerSessionCredentials> {
        return GenericResult.Success(ServerSessionCredentials("stub-token"))
    }
}