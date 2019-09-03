package com.mdgroup.beautyroom.data.api.model

import com.google.gson.annotations.SerializedName

//TODO: remove null possibility after change response in the server
data class MasterApiModel(
    @SerializedName("id")
    val id: Int,
    @SerializedName("first_name")
    val firstName: String?,
    @SerializedName("last_name")
    val lastName: String?,
    @SerializedName("mobile_phone")
    val mobilePhone: String?,
    @SerializedName("information")
    val information: String?,
    @SerializedName("photo")
    val photo: String?,
    @SerializedName("address")
    val address: String?,
    @SerializedName("email")
    val email: String?
)