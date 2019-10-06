package com.mdgroup.beautyroom.domain.interactor

import com.mdgroup.beautyroom.data.api.BeautyRoomApiService
import com.mdgroup.beautyroom.data.api.mapper.AppointmentApiMapper
import com.mdgroup.beautyroom.domain.model.Appointment
import com.mdgroup.beautyroom.domain.model.AppointmentSend

class AppointmentsInteractor(
    private val beautyRoomApiService: BeautyRoomApiService
) {

    suspend fun getAppointments(): List<Appointment> {
        val appointmentApiList = beautyRoomApiService.getAppointments(1)
        return appointmentApiList.map {
            val master = beautyRoomApiService.getMasterDetails(it.masterId)
            AppointmentApiMapper.mapAppointmentApiModelToDomain(it, master)
        }
    }

    suspend fun sendAppointment(appointmentSend: AppointmentSend) {
        val appointmentSendApiModel = AppointmentApiMapper.mapSendAppointmentToApiModel(appointmentSend)
        beautyRoomApiService.sendAppointment(appointmentSendApiModel)
    }

    suspend fun deleteAppointment(appointmentId: Int) = beautyRoomApiService.deleteAppointment(appointmentId)
}