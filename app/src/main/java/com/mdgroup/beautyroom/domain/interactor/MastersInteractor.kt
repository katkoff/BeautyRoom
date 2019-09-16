package com.mdgroup.beautyroom.domain.interactor

import com.mdgroup.beautyroom.data.api.BeautyRoomApiService
import com.mdgroup.beautyroom.data.api.mapper.MasterApiMapper
import com.mdgroup.beautyroom.domain.model.Master

class MastersInteractor(
    private val beautyRoomApiService: BeautyRoomApiService
) {

    suspend fun getMasters(): List<Master> {
        val responseApiModel = beautyRoomApiService.getMasters()
        return MasterApiMapper.mapApiMasterListToDomain(responseApiModel)
    }

    suspend fun getMasterDetails(masterId: Int): Master {
        val masterApiModel = beautyRoomApiService.getMasterDetails(masterId)
        return MasterApiMapper.mapApiMasterModelToDomain(masterApiModel)
    }
}
