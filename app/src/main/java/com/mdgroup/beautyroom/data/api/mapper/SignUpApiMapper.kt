package com.mdgroup.beautyroom.data.api.mapper

import com.mdgroup.beautyroom.data.api.model.SignUpRequestApiModel
import com.mdgroup.beautyroom.domain.model.UserRegInfo

object SignUpApiMapper {

    fun mapToApi(userRegInfo: UserRegInfo) = SignUpRequestApiModel(
        name = userRegInfo.name,
        phone = userRegInfo.phone,
        password = userRegInfo.password
    )
}