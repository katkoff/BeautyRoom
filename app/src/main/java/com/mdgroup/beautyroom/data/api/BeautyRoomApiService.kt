package com.mdgroup.beautyroom.data.api

import com.mdgroup.beautyroom.data.api.model.*
import retrofit2.http.*

interface BeautyRoomApiService {

    @POST("signin")
    suspend fun signIn(@Body signInRequestApiModel: SignInRequestApiModel): SignInResultApiModel

    @POST("signup")
    suspend fun signUp(@Body signUpRequestApiModel: SignUpRequestApiModel): SignInResultApiModel

    @GET("masters")
    suspend fun getMasters(): MasterApiResponseModel

    @GET("masters/{id}/profile")
    suspend fun getMasterDetails(@Path("id") id: Int): MasterApiModel

    @GET("masters/{id}/schedule")
    suspend fun getMasterScheduleByDate(@Path("id") id: Int, @Query("date") date: String): List<TimeBlockApiModel>

    @GET("appointments")
    suspend fun getAppointments(@Query("client") clientId: Int): List<AppointmentApiModel>

    @POST("appointments")
    suspend fun sendAppointments(@Body appointmentSendApiModel: AppointmentSendApiModel)
}