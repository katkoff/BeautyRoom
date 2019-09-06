package com.mdgroup.beautyroom.domain.model

//TODO: rename when will remove GenericResult. This model using in signIn and signUp
// maybe "Token"
// Alex: I see no reason to rename it. The name is the essence of this entity: some data for
// server session. If we add refresh token sometime, it will also be here.
data class ServerSessionCredentials(
    val token: String
)