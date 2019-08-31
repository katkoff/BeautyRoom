package com.mdgroup.beautyroom.data.api.gateway

import com.mdgroup.beautyroom.data.api.BeautyRoomApiService
import com.mdgroup.beautyroom.data.api.mapper.SignInMapper
import com.mdgroup.beautyroom.domain.gateway.SignInGateway
import com.mdgroup.beautyroom.domain.model.SignIn
import com.mdgroup.beautyroom.domain.model.SignInDomainResult

class ApiSignInGateway constructor(
    private val beautyRoomApiService: BeautyRoomApiService
) : SignInGateway {

    override suspend fun signIn(signIn: SignIn): SignInDomainResult {
        val signInApiModel = SignInMapper.mapToSignInApiModel(signIn)
        val signInApiResult = beautyRoomApiService.signIn(signInApiModel)
        return SignInMapper.mapToSignInDomainResult(signInApiResult)
    }
}