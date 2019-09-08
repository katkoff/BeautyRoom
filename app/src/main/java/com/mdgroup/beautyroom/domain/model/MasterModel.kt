package com.mdgroup.beautyroom.domain.model

data class MasterModel(
    val id: String,
    val firstName: String,
    val lastName: String,
    val mobilePhone: String,
    val information: String,
    val photo: String,
    val address: String,
    val email: String
)