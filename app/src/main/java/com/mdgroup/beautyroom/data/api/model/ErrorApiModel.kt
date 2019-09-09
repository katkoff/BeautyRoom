package com.mdgroup.beautyroom.data.api.model

import com.google.gson.annotations.SerializedName

data class ErrorApiModel(
    @SerializedName("errors")
    val errorMessageApiModel: ErrorMessageApiModel
)