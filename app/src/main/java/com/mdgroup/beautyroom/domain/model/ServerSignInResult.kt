package com.mdgroup.beautyroom.domain.model

sealed class ServerSignInResult {

    data class Success(
        val token: String
    ) : ServerSignInResult()

    data class Error(
        val error: Throwable
    ) : ServerSignInResult()
}