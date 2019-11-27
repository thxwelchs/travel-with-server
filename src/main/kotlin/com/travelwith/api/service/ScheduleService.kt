package com.travelwith.api.service

import com.travelwith.api.model.Schedule
import com.travelwith.api.model.ScheduleDTO
import com.travelwith.api.model.mapper.ScheduleMapper
import com.travelwith.api.repository.ScheduleRepository
import org.springframework.stereotype.Service
import java.time.LocalDateTime
import javax.persistence.EntityNotFoundException

@Service
class ScheduleService(
        private val scheduleRepository: ScheduleRepository
) {
    private val scheduleMapper: ScheduleMapper = ScheduleMapper.INSTANCE

    fun getSchedules(): MutableList<Schedule> = scheduleRepository.findAll()

    fun getSchedule(id: Int): ScheduleDTO.BaseDTO {
        val schedule = scheduleRepository.findById(id).orElseThrow{ EntityNotFoundException() }
        scheduleMapper.toDtoWithoutTravel(schedule)

        return ScheduleDTO.BaseDTO(createdAt = LocalDateTime.now())
    }

    fun getMemberHasSchedule(memberId: Int): MutableList<ScheduleDTO.BaseDTO> =
            scheduleRepository.findMemberHasSchedules(memberId)

}