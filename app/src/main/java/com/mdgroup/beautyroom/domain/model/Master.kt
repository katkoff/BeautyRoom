package com.mdgroup.beautyroom.domain.model


data class Master(
    val id: Int,
    val firstName: String,
    val lastName: String,
    val mobilePhone: String,
    val information: String,
    val avatarUrl: String,
    val address: String,
    val email: String,
    val socialNetworks: SocialNetworks,
    val services: List<Service>
)