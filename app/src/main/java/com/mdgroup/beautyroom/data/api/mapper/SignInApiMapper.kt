package com.mdgroup.beautyroom.data.api.mapper

import com.mdgroup.beautyroom.data.api.model.SignInApiResultApiModel
import com.mdgroup.beautyroom.data.api.model.SignInRequestApiModel
import com.mdgroup.beautyroom.domain.model.ServerSessionCredentials
import com.mdgroup.beautyroom.domain.model.UserCredentials

object SignInApiMapper {

    fun mapToApi(domainModel: UserCredentials) = SignInRequestApiModel(
        phone = domainModel.phone,
        password = domainModel.password
    )

    fun mapToDomain(apiModel: SignInApiResultApiModel) = ServerSessionCredentials(
        token = apiModel.token
    )
}