package com.travelwith.api.model.mapper

import com.travelwith.api.model.Schedule
import com.travelwith.api.model.ScheduleDTO
import org.mapstruct.Mapper
import org.mapstruct.Mapping
import org.mapstruct.factory.Mappers

@Mapper(
        componentModel = "spring"
)
interface ScheduleMapper {
    companion object {
        val INSTANCE = Mappers.getMapper(ScheduleMapper::class.java)
    }

    @Mapping(target = "travel", ignore = true)
    fun toDtoWithoutTravel(entity: Schedule): ScheduleDTO
}