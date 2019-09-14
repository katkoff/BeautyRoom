package com.mdgroup.beautyroom.data.api.mapper

import com.mdgroup.beautyroom.data.api.model.MasterApiModel
import com.mdgroup.beautyroom.data.api.model.MasterApiResponseModel
import com.mdgroup.beautyroom.domain.model.Master

object MasterApiMapper {

    fun mapApiMasterListToDomain(masterApiResponseModel: MasterApiResponseModel): List<Master> {
        val masters = masterApiResponseModel.masters
        return if (masters.isEmpty()) {
            emptyList()
        } else {
            masters.map { mapApiMasterModelToDomain(it) }
        }
    }

    fun mapApiMasterModelToDomain(masterApiModel: MasterApiModel) = Master(
        id = masterApiModel.id,
        firstName = masterApiModel.firstName.orEmpty(),
        lastName = masterApiModel.lastName.orEmpty(),
        mobilePhone = masterApiModel.mobilePhone.orEmpty(),
        information = masterApiModel.information.orEmpty(),
        photo = masterApiModel.photo.orEmpty(),
        address = masterApiModel.address.orEmpty(),
        email = masterApiModel.email.orEmpty()
    )
}