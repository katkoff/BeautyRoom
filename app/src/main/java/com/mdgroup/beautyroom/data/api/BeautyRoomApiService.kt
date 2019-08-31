package com.mdgroup.beautyroom.data.api

import com.mdgroup.beautyroom.domain.model.ServerSignInResult
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface BeautyRoomApiService {

    @POST("authenticate")
    @FormUrlEncoded
    suspend fun signIn(
        @Field("login") login: String,
        @Field("password") password: String
    ): ServerSignInResult
}