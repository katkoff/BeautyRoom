package com.mdgroup.beautyroom.domain.model

import org.threeten.bp.LocalDateTime

data class AppointmentSend(
    val clientId: Int,
    val serviceId: Int,
    val masterId: Int,
    val dateTime: LocalDateTime
)