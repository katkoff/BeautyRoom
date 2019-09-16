package com.mdgroup.beautyroom.data.api.model

import com.google.gson.annotations.SerializedName

data class MasterApiModel(
    @SerializedName("id")
    val id: Int,
    @SerializedName("first_name")
    val firstName: String,
    @SerializedName("last_name")
    val lastName: String,
    @SerializedName("mobile_phone")
    val mobilePhone: String,
    @SerializedName("information")
    val information: String,
    @SerializedName("avatar_url")
    val avatarUrl: String,
    @SerializedName("address")
    val address: String,
    @SerializedName("email")
    val email: String,
    @SerializedName("social_networks")
    val socialNetworks: SocialNetworksApiModel,
    @SerializedName("services")
    val services: List<ServiceApiModel>
)