package com.mdgroup.beautyroom.domain.interactor

import com.mdgroup.beautyroom.data.api.BeautyRoomApiService
import com.mdgroup.beautyroom.data.api.mapper.MasterApiMapper
import com.mdgroup.beautyroom.domain.model.MasterModel

class MastersInteractor(
    private val beautyRoomApiService: BeautyRoomApiService
) {

    suspend fun getMasters(): List<MasterModel> {
        val responseModel = beautyRoomApiService.getMasters()
        return MasterApiMapper.mapApiMasterListToDomain(responseModel)
    }
}
