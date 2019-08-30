package com.mdgroup.beautyroom.data.api

import com.mdgroup.beautyroom.data.api.model.SignInApiModel
import com.mdgroup.beautyroom.domain.model.ServerSignInResult
import retrofit2.http.Headers
import retrofit2.http.POST

interface BeautyRoomApiService {

    @POST("authenticate")
    @Headers("Content-Type: application/x-www-form-urlencoded")
    fun signIn(mapToSignInApiModel: SignInApiModel): ServerSignInResult

}