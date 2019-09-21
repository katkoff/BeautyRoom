package com.mdgroup.beautyroom.data.local

import com.mdgroup.beautyroom.domain.model.Master
import com.mdgroup.beautyroom.domain.model.Service
import org.threeten.bp.LocalDateTime

data class AppointmentState(
    val master: Master?,
    val service: Service?,
    val appointmentDateTime: LocalDateTime?
)