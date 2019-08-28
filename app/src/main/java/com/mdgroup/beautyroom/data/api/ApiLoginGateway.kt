package com.mdgroup.beautyroom.data.api

import com.mdgroup.beautyroom.domain.gateway.LoginGateway
import com.mdgroup.beautyroom.domain.model.ServerLoginResult

class ApiLoginGateway : LoginGateway {

    override suspend fun login(login: String, password: String): ServerLoginResult {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}