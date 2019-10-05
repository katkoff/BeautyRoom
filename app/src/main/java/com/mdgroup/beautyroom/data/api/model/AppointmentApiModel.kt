package com.mdgroup.beautyroom.data.api.model

import com.google.gson.annotations.SerializedName

data class AppointmentApiModel(
    @SerializedName("appointmentId")
    val appointmentId: Int,
    @SerializedName("masterId")
    val masterId: Int,
    @SerializedName("date")
    val appointmentDateTime: String,
    @SerializedName("serviceName")
    val serviceName: String,
    @SerializedName("duration")
    val serviceDuration: Int
)