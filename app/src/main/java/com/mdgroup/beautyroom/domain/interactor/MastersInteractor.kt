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

    suspend fun getMasterDetails(masterId: String): Master {
        //TODO: Remove mocking data and uncomment
//       val masterApiModel = beautyRoomApiService.getMasterDetails(masterId)
//        return MasterApiMapper.mapApiMasterModelToDomain(masterApiModel)

        return Master(
            id = masterId,
            firstName = "Джесси",
            lastName = "Пинкман",
            mobilePhone = "+79239998877",
            information = "Лучший мастер бровей во всём Новосибирске! Брови как у Брежнева, Бейонс, " +
                    "или у вашего лучшего друга!",
            photo = "https://cdn.wallpapersafari.com/67/37/prDVYb.jpg",
            email = "whassup@gmail.com",
            address = "г. Новосибирск, ул. Николаева, 11"
        )
    }
}
