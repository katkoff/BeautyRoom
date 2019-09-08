package com.mdgroup.beautyroom.domain.interactor

import com.mdgroup.beautyroom.data.api.BeautyRoomApiService
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
        sessionInteractor.serverSession = ServerSession(responseModel.token)
    }
}
