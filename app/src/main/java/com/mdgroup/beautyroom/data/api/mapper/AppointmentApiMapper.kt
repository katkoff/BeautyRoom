package com.mdgroup.beautyroom.data.api.mapper

import com.mdgroup.beautyroom.data.api.model.AppointmentApiModel
import com.mdgroup.beautyroom.data.api.model.AppointmentSendApiModel
import com.mdgroup.beautyroom.data.api.model.MasterApiModel
import com.mdgroup.beautyroom.domain.model.Appointment
import com.mdgroup.beautyroom.domain.model.AppointmentSend
import org.threeten.bp.LocalDateTime
import org.threeten.bp.format.DateTimeFormatter

object AppointmentApiMapper {

    /**
     * Get appointment
     */
//
//    fun mapApiAppointmentListToDomain(appointmentApiList: List<AppointmentApiModel>): List<Appointment> =
//        if (appointmentApiList.isEmpty()) {
//            emptyList()
//        } else {
//            appointmentApiList.map { mapAppointmentApiModelToDomain(it) }
//        }

    fun mapAppointmentApiModelToDomain(
        appointmentApiModel: AppointmentApiModel,
        masterApiModel: MasterApiModel
    ): Appointment {
        val dateTime = LocalDateTime.parse(
            appointmentApiModel.appointmentDateTime,
            DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"))
//        return Appointment(
//            appointmentId = appointmentApiModel.appointmentId,
//            masterId = appointmentApiModel.masterId,
//            appointmentDateTime = dateTime,
//            serviceName = appointmentApiModel.serviceName,
//            serviceDuration = appointmentApiModel.serviceDuration
//        )
        return Appointment(
            appointmentId = appointmentApiModel.appointmentId,
            serviceName = appointmentApiModel.serviceName,
            masterName = "${masterApiModel.firstName} ${masterApiModel.lastName}",
            masterPhoneNumber = masterApiModel.mobilePhone,
            masterAddress = masterApiModel.address,
            servicePrice = masterApiModel.services.first { it.name == appointmentApiModel.serviceName }.price,
            serviceDuration = appointmentApiModel.serviceDuration,
            appointmentDateTime = dateTime

        )
    }

    /**
     * Send appointment
     */

    fun mapSendAppointmentToApiModel(sendAppointment: AppointmentSend): AppointmentSendApiModel {
        return AppointmentSendApiModel(
            clientId = sendAppointment.clientId,
            serviceId = sendAppointment.serviceId,
            masterId = sendAppointment.masterId,
            dateTime = sendAppointment.dateTime.toString()
        )
    }
}