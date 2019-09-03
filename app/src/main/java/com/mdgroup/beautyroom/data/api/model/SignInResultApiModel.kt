package com.mdgroup.beautyroom.data.api.model

import com.google.gson.annotations.SerializedName

/**
 * Same result model for both of signIn and signUp requests
 */
//TODO: Suppose we'll have to rename this entity 'cause it's same result model for signIn and -up
data class SignInResultApiModel(
    @SerializedName("msg")
    val message: String,
    @SerializedName("token")
    val token: String
)