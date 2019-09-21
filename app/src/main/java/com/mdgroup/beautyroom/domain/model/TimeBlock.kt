package com.mdgroup.beautyroom.domain.model

import org.threeten.bp.LocalTime

data class TimeBlock(
    val startTime: LocalTime,
    val isEnable: Boolean
)