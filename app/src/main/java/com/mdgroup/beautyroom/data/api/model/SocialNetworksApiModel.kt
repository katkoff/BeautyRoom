package com.mdgroup.beautyroom.data.api.model

import com.google.gson.annotations.SerializedName

data class SocialNetworksApiModel(
    @SerializedName("instagram")
    val instagram: String
)