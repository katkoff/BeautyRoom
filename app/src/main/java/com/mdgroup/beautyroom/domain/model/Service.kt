package com.mdgroup.beautyroom.domain.model

data class Service(
    val id: Int,
    val name: String,
    val description: String,
    val duration: Int,
    val price: Int
)