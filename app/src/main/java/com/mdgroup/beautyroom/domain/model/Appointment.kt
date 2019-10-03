package com.mdgroup.beautyroom.domain.model

import org.threeten.bp.LocalDateTime

data class Appointment(
    val appointmentId: Int,
    val masterId: Int,
    val appointmentDateTime: LocalDateTime,
    val serviceName: String,
    val serviceDuration: Int
)