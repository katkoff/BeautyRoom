package com.mdgroup.beautyroom.domain.interactor

import com.mdgroup.beautyroom.domain.gateway.MastersGateway
import com.mdgroup.beautyroom.domain.model.MasterModel

class MastersInteractor(
    private val mastersGateway: MastersGateway
) {

    suspend fun getMasters(): List<MasterModel> = mastersGateway.getMasters()
}