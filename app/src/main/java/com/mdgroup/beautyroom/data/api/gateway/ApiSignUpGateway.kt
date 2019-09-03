package com.mdgroup.beautyroom.data.api.gateway

import com.mdgroup.beautyroom.data.api.BeautyRoomApiService
import com.mdgroup.beautyroom.data.api.mapper.SignInApiMapper
import com.mdgroup.beautyroom.data.api.mapper.SignUpApiMapper
import com.mdgroup.beautyroom.domain.gateway.SignUpGateway
import com.mdgroup.beautyroom.domain.model.ServerSessionCredentials
import com.mdgroup.beautyroom.domain.model.UserRegInfo

class ApiSignUpGateway constructor(
    private val beautyRoomApiService: BeautyRoomApiService
) : SignUpGateway {

    override suspend fun signUp(userRegInfo: UserRegInfo): ServerSessionCredentials {
        val requestModel = SignUpApiMapper.mapToApi(userRegInfo)
        val responseModel = beautyRoomApiService.signUp(requestModel)
        return SignInApiMapper.mapToDomain(responseModel)
    }
}