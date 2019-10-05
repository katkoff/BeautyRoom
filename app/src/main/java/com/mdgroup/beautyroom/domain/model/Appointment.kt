package com.mdgroup.beautyroom.domain.model

import org.threeten.bp.LocalDateTime

data class Appointment(
    val appointmentId: Int,
    val serviceName: String,
    val masterName: String,
    val masterPhoneNumber: String,
    val masterAddress: String,
    val servicePrice: Int,
    val serviceDuration: Int,
    val appointmentDateTime: LocalDateTime
)