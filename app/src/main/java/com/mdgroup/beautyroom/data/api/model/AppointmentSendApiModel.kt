package com.mdgroup.beautyroom.data.api.model

import com.google.gson.annotations.SerializedName

data class AppointmentSendApiModel(
    @SerializedName("clientId")
    val clientId: Int,
    @SerializedName("serviceId")
    val serviceId: Int,
    @SerializedName("masterId")
    val masterId: Int,
    @SerializedName("dateTime")
    val dateTime: String
)