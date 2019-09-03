package com.mdgroup.beautyroom.data.api.model

import com.google.gson.annotations.SerializedName

data class SignUpRequestApiModel(
    @SerializedName("name")
    val name: String,
    @SerializedName("login")
    val phone: String,
    @SerializedName("password")
    val password: String
)