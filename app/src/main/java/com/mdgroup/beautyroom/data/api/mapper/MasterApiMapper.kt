package com.mdgroup.beautyroom.data.api.mapper

import com.mdgroup.beautyroom.data.api.model.MasterApiModel
import com.mdgroup.beautyroom.data.api.model.MasterApiResponseModel
import com.mdgroup.beautyroom.data.api.model.ServiceApiModel
import com.mdgroup.beautyroom.domain.model.Master
import com.mdgroup.beautyroom.domain.model.Service
import com.mdgroup.beautyroom.domain.model.SocialNetworks

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
        firstName = masterApiModel.firstName,
        lastName = masterApiModel.lastName,
        mobilePhone = masterApiModel.mobilePhone,
        information = masterApiModel.information,
        photo = masterApiModel.avatarUrl,
        address = masterApiModel.address,
        email = masterApiModel.email,
        socialNetworks = SocialNetworks(instagram = masterApiModel.socialNetworks.instagram),
        services = mapApiServiceListToDomain(masterApiModel.services)
    )

    private fun mapApiServiceListToDomain(serviceApiModels: List<ServiceApiModel>?): List<Service> {
        return serviceApiModels?.let { list ->
            list.map {
                mapApiServiceToDomain(it)
            }
        } ?: emptyList()
    }

    private fun mapApiServiceToDomain(serviceApiModel: ServiceApiModel) = Service(
        id = serviceApiModel.id,
        name = serviceApiModel.name,
        description = serviceApiModel.description,
        duration = serviceApiModel.duration,
        price = serviceApiModel.price
    )
}