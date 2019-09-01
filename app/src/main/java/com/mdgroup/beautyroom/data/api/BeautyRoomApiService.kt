package com.mdgroup.beautyroom.data.api

import com.mdgroup.beautyroom.data.api.model.SignInApiResultApiModel
import com.mdgroup.beautyroom.data.api.model.SignInRequestApiModel
import retrofit2.http.Body
import retrofit2.http.POST

interface BeautyRoomApiService {

    @POST("signin")
    suspend fun signIn(
        @Body signInApiModel: SignInRequestApiModel
    ): SignInApiResultApiModel
}