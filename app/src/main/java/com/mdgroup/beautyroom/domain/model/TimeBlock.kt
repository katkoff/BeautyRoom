package com.mdgroup.beautyroom.domain.model

import org.threeten.bp.LocalDateTime

data class TimeBlock(
    val startTime: LocalDateTime,
    val duration: Int,
    val isEnable: Boolean
)