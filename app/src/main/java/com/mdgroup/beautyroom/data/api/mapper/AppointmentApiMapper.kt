package com.mdgroup.beautyroom.data.api.mapper

import com.mdgroup.beautyroom.data.api.model.AppointmentApiModel
import com.mdgroup.beautyroom.domain.model.Appointment
import org.threeten.bp.LocalDateTime
import org.threeten.bp.format.DateTimeFormatter

object AppointmentApiMapper {

    fun mapApiAppointmentListToDomain(appointmentApiList: List<AppointmentApiModel>): List<Appointment> =
        if (appointmentApiList.isEmpty()) {
            emptyList()
        } else {
            appointmentApiList.map { mapAppointmentApiModelToDomain(it) }
        }

    private fun mapAppointmentApiModelToDomain(appointmentApiModel: AppointmentApiModel): Appointment {
        val dateTime = LocalDateTime.parse(
            appointmentApiModel.appointmentDateTime,
            DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"))
        return Appointment(
            appointmentId = appointmentApiModel.appointmentId,
            masterId = appointmentApiModel.masterId,
            appointmentDateTime = dateTime,
            serviceName = appointmentApiModel.serviceName,
            serviceDuration = appointmentApiModel.serviceDuration
        )
    }
}