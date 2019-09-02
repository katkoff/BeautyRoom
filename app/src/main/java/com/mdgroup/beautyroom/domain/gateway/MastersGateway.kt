package com.mdgroup.beautyroom.domain.gateway

import com.mdgroup.beautyroom.domain.model.MasterModel

interface MastersGateway {

    suspend fun getMasters(): List<MasterModel>
}