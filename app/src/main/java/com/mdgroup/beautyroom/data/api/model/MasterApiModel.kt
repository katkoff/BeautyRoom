package com.mdgroup.beautyroom.data.api.model

import com.google.gson.annotations.SerializedName

data class MasterApiModel(
    @SerializedName("id")
    val id: Int,
    @SerializedName("firstName")
    val firstName: String,
    @SerializedName("lastName")
    val lastName: String,
    @SerializedName("mobilePhone")
    val mobilePhone: String,
    @SerializedName("information")
    val information: String,
    @SerializedName("avatarUrl")
    val avatarUrl: String,
    @SerializedName("address")
    val address: String,
    @SerializedName("email")
    val email: String,
    @SerializedName("socialNetworks")
    val socialNetworks: SocialNetworksApiModel,
    @SerializedName("services")
    val services: List<ServiceApiModel>
)