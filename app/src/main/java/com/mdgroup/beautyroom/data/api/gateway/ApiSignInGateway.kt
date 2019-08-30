package com.mdgroup.beautyroom.data.api.gateway

import com.mdgroup.beautyroom.data.api.BeautyRoomApiService
import com.mdgroup.beautyroom.data.api.mapper.SignInMapper
import com.mdgroup.beautyroom.domain.gateway.SignInGateway
import com.mdgroup.beautyroom.domain.model.ServerSignInResult
import com.mdgroup.beautyroom.domain.model.SignIn

class ApiSignInGateway constructor(
    private val beautyRoomApiService: BeautyRoomApiService
) : SignInGateway {

    override suspend fun signIn(signIn: SignIn): ServerSignInResult {
        return beautyRoomApiService.signIn(SignInMapper.mapToSignInApiModel(signIn))
    }
}