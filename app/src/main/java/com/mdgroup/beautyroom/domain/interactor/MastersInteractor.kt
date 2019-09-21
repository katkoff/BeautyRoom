package com.mdgroup.beautyroom.domain.interactor

import com.mdgroup.beautyroom.data.api.BeautyRoomApiService
import com.mdgroup.beautyroom.data.api.mapper.MasterApiMapper
import com.mdgroup.beautyroom.data.api.mapper.TimeBlockApiMapper
import com.mdgroup.beautyroom.domain.model.Master
import com.mdgroup.beautyroom.domain.model.TimeBlock
import org.threeten.bp.LocalDate
import org.threeten.bp.format.DateTimeFormatter

class MastersInteractor(
    private val beautyRoomApiService: BeautyRoomApiService
) {

    suspend fun getMasters(): List<Master> {
        val responseApiModel = beautyRoomApiService.getMasters()
        return MasterApiMapper.mapApiMasterListToDomain(responseApiModel)
    }

    suspend fun getMasterDetails(masterId: Int): Master {
        val masterApiModel = beautyRoomApiService.getMasterDetails(masterId)
        return MasterApiMapper.mapApiMasterModelToDomain(masterApiModel)
    }

    suspend fun getMasterScheduleByDate(masterId: Int, date: LocalDate): List<TimeBlock> {
        val dateString = date.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"))
        val timeBlockApiList = beautyRoomApiService.getMasterScheduleByDate(masterId, dateString)
        return TimeBlockApiMapper.mapApiTimeBlockListToDomain(timeBlockApiList)
    }
}
