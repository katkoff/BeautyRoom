package com.mdgroup.beautyroom.data.api.model

import com.google.gson.annotations.SerializedName

data class SignInApiResult(
    @SerializedName("msg")
    val message: String,
    @SerializedName("token")
    val token: String
)