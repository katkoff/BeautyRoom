package com.mdgroup.beautyroom.data.api.model

import com.google.gson.annotations.SerializedName

data class ServiceApiModel(
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("description")
    val description: String,
    @SerializedName("price")
    val price: Int,
    @SerializedName("duration")
    val duration: Int
)