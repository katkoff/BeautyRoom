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
        
        return AppointmentApiMapper.mapApiAppointmentListToDomain(appointmentApiList)
    }

    suspend fun sendAppointments(appointmentSend: AppointmentSend) {
        val appointmentSendApiModel = AppointmentApiMapper.mapSendAppointmentToApiModel(appointmentSend)
        beautyRoomApiService.sendAppointments(appointmentSendApiModel)
    }
}