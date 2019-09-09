package com.mdgroup.beautyroom.data.api.model

import com.google.gson.annotations.SerializedName

data class ErrorMessageApiModel(
    @SerializedName("msg")
    val message: String
)