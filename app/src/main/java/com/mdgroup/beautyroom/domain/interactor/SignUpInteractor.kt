package com.mdgroup.beautyroom.domain.interactor

import com.mdgroup.beautyroom.data.api.BeautyRoomApiService
import com.mdgroup.beautyroom.data.api.mapper.SignInApiMapper
import com.mdgroup.beautyroom.data.api.mapper.SignUpApiMapper
import com.mdgroup.beautyroom.domain.model.ServerSession
import com.mdgroup.beautyroom.domain.model.UserRegInfo

class SignUpInteractor(
    private val sessionInteractor: SessionInteractor,
    private val beautyRoomApiService: BeautyRoomApiService
) {

    suspend fun signUp(userRegInfo: UserRegInfo) {
        val requestModel = SignUpApiMapper.mapToApi(userRegInfo)
        val responseModel = beautyRoomApiService.signUp(requestModel)
        val sessionCredentials = SignInApiMapper.mapToDomain(responseModel)
        sessionInteractor.serverSession = ServerSession(sessionCredentials)
    }
}
