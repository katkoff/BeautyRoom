package com.mdgroup.beautyroom.data.api

import com.mdgroup.beautyroom.data.api.model.*
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

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

    @GET("masters/{id}/profile")
    suspend fun getMasterDetails(@Path("id") id: Int): MasterApiModel
}