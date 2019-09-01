package com.mdgroup.beautyroom.domain.gateway

import com.mdgroup.beautyroom.domain.model.GenericResult
import com.mdgroup.beautyroom.domain.model.ServerSessionCredentials
import com.mdgroup.beautyroom.domain.model.UserCredentials

interface SignInGateway {

    suspend fun signIn(userCredentials: UserCredentials): GenericResult<ServerSessionCredentials>
}