package com.mdgroup.beautyroom.domain.gateway

import com.mdgroup.beautyroom.domain.model.SignIn
import com.mdgroup.beautyroom.domain.model.SignInDomainResult

interface SignInGateway {

    suspend fun signIn(signIn: SignIn): SignInDomainResult
}