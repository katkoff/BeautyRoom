package com.mdgroup.beautyroom.data.api.mapper

import com.mdgroup.beautyroom.data.api.model.MasterApiModel
import com.mdgroup.beautyroom.data.api.model.MasterApiResponseModel
import com.mdgroup.beautyroom.domain.model.MasterModel

object MasterApiMapper {

    fun mapApiMasterListToDomain(masterApiResponseModel: MasterApiResponseModel): List<MasterModel> {
        val masters = masterApiResponseModel.masters
        return if (masters.isEmpty()) {
            emptyList()
        } else {
            masters.map { mapApiMasterModelToDomain(it) }
        }
    }

    private fun mapApiMasterModelToDomain(masterApiModel: MasterApiModel) = MasterModel(
        id = masterApiModel.id,
        firstName = masterApiModel.firstName,
        lastName = masterApiModel.lastName,
        mobilePhone = masterApiModel.mobilePhone,
        information = masterApiModel.information,
        photo = masterApiModel.photo,
        address = masterApiModel.address,
        email = masterApiModel.email
    )
}