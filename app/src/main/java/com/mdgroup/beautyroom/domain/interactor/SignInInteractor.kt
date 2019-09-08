package com.mdgroup.beautyroom.domain.interactor

import com.mdgroup.beautyroom.data.api.BeautyRoomApiService
import com.mdgroup.beautyroom.data.api.mapper.SignInApiMapper
import com.mdgroup.beautyroom.domain.model.ServerSession
import com.mdgroup.beautyroom.domain.model.UserCredentials

class SignInInteractor(
    private val sessionInteractor: SessionInteractor,
    private val beautyRoomApiService: BeautyRoomApiService
) {

    suspend fun signIn(userCredentials: UserCredentials) {
        val signInRequestApiModel = SignInApiMapper.mapToApi(userCredentials)
        val signInResultApiModel = beautyRoomApiService.signIn(signInRequestApiModel)
        sessionInteractor.serverSession = ServerSession(signInResultApiModel.token)
    }
}
