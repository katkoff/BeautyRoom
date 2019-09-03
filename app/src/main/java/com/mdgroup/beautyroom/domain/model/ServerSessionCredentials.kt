package com.mdgroup.beautyroom.domain.model

//TODO: rename when will remove GenericResult. This model using in signIn and signUp
// maybe "Token"
data class ServerSessionCredentials(
    val token: String
)