package com.mdgroup.beautyroom.data.api.model

import com.google.gson.annotations.SerializedName

class SignInApiModel(
    @SerializedName("login")
    val phone: String,
    @SerializedName("password")
    val password: String
)