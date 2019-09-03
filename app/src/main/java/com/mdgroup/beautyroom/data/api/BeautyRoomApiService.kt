package com.mdgroup.beautyroom.data.api

import com.mdgroup.beautyroom.data.api.model.MasterApiResponseModel
import com.mdgroup.beautyroom.data.api.model.SignInRequestApiModel
import com.mdgroup.beautyroom.data.api.model.SignInResultApiModel
import com.mdgroup.beautyroom.data.api.model.SignUpRequestApiModel
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface BeautyRoomApiService {

    @POST("signin")
    suspend fun signIn(
        @Body signInRequestApiModel: SignInRequestApiModel
    ): SignInResultApiModel

    @POST("signup")
    suspend fun signUp(
        @Body signUpRequestApiModel: SignUpRequestApiModel
    ): SignInResultApiModel

    @GET("masters")
    suspend fun getMasters(): MasterApiResponseModel
}