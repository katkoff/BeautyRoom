package com.mdgroup.beautyroom.domain.model

//TODO: delete when will remove GenericResult
// Alex: why delete? We need some representation of a server session. We can add session
// status here, and use it to manage sign in and sign up.
data class ServerSession(
    val credentials: ServerSessionCredentials
)