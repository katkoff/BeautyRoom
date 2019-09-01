package com.mdgroup.beautyroom.data.api.gateway

import com.mdgroup.beautyroom.data.api.BeautyRoomApiService
import com.mdgroup.beautyroom.data.api.mapper.SignInApiMapper
import com.mdgroup.beautyroom.domain.gateway.SignInGateway
import com.mdgroup.beautyroom.domain.model.GenericResult
import com.mdgroup.beautyroom.domain.model.ServerSessionCredentials
import com.mdgroup.beautyroom.domain.model.UserCredentials

class ApiSignInGateway constructor(
    private val beautyRoomApiService: BeautyRoomApiService
) : SignInGateway {

    override suspend fun signIn(userCredentials: UserCredentials): GenericResult<ServerSessionCredentials> {
        val signInApiModel = SignInApiMapper.mapToApi(userCredentials)
        return GenericResult.from {
            val signInApiResult = beautyRoomApiService.signIn(signInApiModel)
            SignInApiMapper.mapToDomain(signInApiResult)
        }
    }
}