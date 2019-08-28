package com.mdgroup.beautyroom.domain.gateway

import com.mdgroup.beautyroom.domain.model.ServerSignInResult

interface SignInGateway {

    suspend fun signIn(login: String, password: String): ServerSignInResult
}