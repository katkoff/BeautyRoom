package com.mdgroup.beautyroom.domain.gateway

import com.mdgroup.beautyroom.domain.model.ServerSessionCredentials
import com.mdgroup.beautyroom.domain.model.UserRegInfo

interface SignUpGateway {

    suspend fun signUp(userRegInfo: UserRegInfo): ServerSessionCredentials
}