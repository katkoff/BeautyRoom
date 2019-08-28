package com.mdgroup.beautyroom.domain.model

sealed class LoginResult {

    object Success : LoginResult()

    data class Error(
        val message: String
    ) : LoginResult()
}
