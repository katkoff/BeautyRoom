package com.mdgroup.beautyroom.data.api.gateway

import com.mdgroup.beautyroom.data.api.BeautyRoomApiService
import com.mdgroup.beautyroom.data.api.mapper.MasterApiMapper
import com.mdgroup.beautyroom.domain.gateway.MastersGateway
import com.mdgroup.beautyroom.domain.model.MasterModel

class ApiMastersGateway constructor(
    private val beautyRoomApiService: BeautyRoomApiService
) : MastersGateway {

    override suspend fun getMasters(): List<MasterModel> {
        val responseModel = beautyRoomApiService.getMasters()
        return MasterApiMapper.mapApiMasterListToDomain(responseModel)
    }
}