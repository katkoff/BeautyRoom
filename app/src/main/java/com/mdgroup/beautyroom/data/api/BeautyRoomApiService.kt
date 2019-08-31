package com.mdgroup.beautyroom.data.api

import com.mdgroup.beautyroom.data.api.model.SignInApiModel
import com.mdgroup.beautyroom.data.api.model.SignInApiResult
import retrofit2.http.Body
import retrofit2.http.POST

interface BeautyRoomApiService {

    @POST("signin")
//    @FormUrlEncoded
//    @Headers("Content-Type: ")
    suspend fun signIn(@Body signInApiModel: SignInApiModel): SignInApiResult
}