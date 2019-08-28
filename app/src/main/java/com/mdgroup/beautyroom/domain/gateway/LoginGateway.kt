package com.mdgroup.beautyroom.domain.gateway

import com.mdgroup.beautyroom.domain.model.ServerLoginResult

interface LoginGateway {

    suspend fun login(login: String, password: String): ServerLoginResult
}