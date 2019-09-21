package com.mdgroup.beautyroom.data.api.model

import com.google.gson.annotations.SerializedName

data class TimeBlockApiModel(
    @SerializedName("startTime")
    val startTime: String,
    @SerializedName("isEnable")
    val isEnable: Boolean
)