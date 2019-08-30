package com.mdgroup.beautyroom.domain.gateway

import com.mdgroup.beautyroom.domain.model.ServerSignInResult
import com.mdgroup.beautyroom.domain.model.SignIn

interface SignInGateway {

    suspend fun signIn(signIn: SignIn): ServerSignInResult
}