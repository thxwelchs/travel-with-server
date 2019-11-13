package com.travelwith.api.controller

import com.travelwith.api.annotaion.V1ApiController
import com.travelwith.api.model.Schedule
import com.travelwith.api.repository.ScheduleRepository
import io.swagger.annotations.Api
import io.swagger.annotations.ApiOperation
import io.swagger.annotations.ApiParam
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import javax.persistence.EntityNotFoundException

@Api(description = "Schedule(일정) API")
@V1ApiController
class ScheduleController(
        private val scheduleRepository: ScheduleRepository
) {

    @ApiOperation(value = "전체 일정 조회")
    @GetMapping("/schedules")
    fun getSchedules(): MutableList<Schedule> {
        return scheduleRepository.findAll()
    }

    @ApiOperation(value = "{id} 일정 조회")
    @GetMapping("/schedules/{id}")
    fun getSchedules(
            @ApiParam(value = "일정 PK", required = true) @PathVariable id: Int
    ): Schedule? {

        return scheduleRepository.findById(id).orElseThrow{ EntityNotFoundException() }
    }
}