package com.mdgroup.beautyroom.data.stub

import com.mdgroup.beautyroom.domain.gateway.LoginGateway
import com.mdgroup.beautyroom.domain.model.ServerLoginResult

class StubLoginGateway : LoginGateway {

    override suspend fun login(login: String, password: String): ServerLoginResult {
        return ServerLoginResult.Success("stub-token")
    }
}