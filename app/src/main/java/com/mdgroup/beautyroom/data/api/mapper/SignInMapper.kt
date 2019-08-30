package com.mdgroup.beautyroom.data.api.mapper

import com.mdgroup.beautyroom.data.api.model.SignInApiModel
import com.mdgroup.beautyroom.domain.model.SignIn

object SignInMapper {

    fun mapToSignInApiModel(signIn: SignIn) = SignInApiModel(
        phone = signIn.phone,
        password = signIn.password
    )
}