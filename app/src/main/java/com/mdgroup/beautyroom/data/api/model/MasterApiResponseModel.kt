package com.mdgroup.beautyroom.data.api.model

import com.google.gson.annotations.SerializedName

data class MasterApiResponseModel(
    @SerializedName("totalItemsCount")
    val totalItemsCount: Int?,
    @SerializedName("items")
    val masters: List<MasterApiModel>?
)