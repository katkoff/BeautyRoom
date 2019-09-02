package com.mdgroup.beautyroom.data.api

import com.mdgroup.beautyroom.data.api.model.MasterApiResponseModel
import com.mdgroup.beautyroom.data.api.model.SignInRequestApiModel
import com.mdgroup.beautyroom.data.api.model.SignInResultApiModel
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface BeautyRoomApiService {

    @POST("signin")
    suspend fun signIn(
        @Body signInApiModel: SignInRequestApiModel
    ): SignInResultApiModel

    @GET("masters")
    suspend fun getMasters(): MasterApiResponseModel
}