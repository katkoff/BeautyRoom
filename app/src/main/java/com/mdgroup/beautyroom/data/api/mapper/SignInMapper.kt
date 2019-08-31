package com.mdgroup.beautyroom.data.api.mapper

import com.mdgroup.beautyroom.data.api.model.SignInApiModel
import com.mdgroup.beautyroom.data.api.model.SignInApiResult
import com.mdgroup.beautyroom.domain.model.SignIn
import com.mdgroup.beautyroom.domain.model.SignInDomainResult

object SignInMapper {

    fun mapToSignInApiModel(signIn: SignIn) = SignInApiModel(
        phone = signIn.phone,
        password = signIn.password
    )

    fun mapToSignInDomainResult(signInApiResult: SignInApiResult) = SignInDomainResult(
        message = signInApiResult.message,
        token = signInApiResult.token
    )
}