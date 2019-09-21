package com.mdgroup.beautyroom.data.local

import com.mdgroup.beautyroom.domain.model.Master
import com.mdgroup.beautyroom.domain.model.Service
import org.threeten.bp.LocalDate
import org.threeten.bp.LocalTime

data class AppointmentState(
    val master: Master?,
    val service: Service?,
    val appointmentDate: LocalDate?,
    val appointmentTime: LocalTime?
)