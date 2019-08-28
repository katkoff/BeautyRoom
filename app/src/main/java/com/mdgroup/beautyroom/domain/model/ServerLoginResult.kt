package com.mdgroup.beautyroom.domain.model

sealed class ServerLoginResult {

    data class Success(
        val token: String
    ) : ServerLoginResult()

    data class Error(
        val error: Throwable
    ) : ServerLoginResult()
}