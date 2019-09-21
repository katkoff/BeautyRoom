package com.mdgroup.beautyroom.data.api.mapper

import com.mdgroup.beautyroom.data.api.model.TimeBlockApiModel
import com.mdgroup.beautyroom.domain.model.TimeBlock
import org.threeten.bp.LocalTime

object TimeBlockApiMapper {

    fun mapApiTimeBlockListToDomain(timeBlockApiList: List<TimeBlockApiModel>): List<TimeBlock> {
        return timeBlockApiList.map { mapApiTimeBlockModelToDomain(it) }
    }

    private fun mapApiTimeBlockModelToDomain(timeBlockApiModel: TimeBlockApiModel): TimeBlock {
        val localTime: LocalTime = LocalTime.parse(timeBlockApiModel.startTime)
        return TimeBlock(
            startTime = localTime,
            isEnable = timeBlockApiModel.isEnable
        )
    }
}