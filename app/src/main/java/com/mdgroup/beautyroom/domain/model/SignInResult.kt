package com.mdgroup.beautyroom.domain.model

sealed class SignInResult {

    object Success : SignInResult()

    data class Error(
        val message: String
    ) : SignInResult()
}
