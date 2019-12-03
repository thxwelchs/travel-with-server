package com.travelwith.api.controller

import com.travelwith.api.annotaion.V1ApiController
import com.travelwith.api.model.ApiResponse
import com.travelwith.api.model.Schedule
import com.travelwith.api.model.ScheduleDTO
import com.travelwith.api.repository.ScheduleRepository
import com.travelwith.api.service.ScheduleService
import io.swagger.annotations.Api
import io.swagger.annotations.ApiOperation
import io.swagger.annotations.ApiParam
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import javax.persistence.EntityNotFoundException

@Api(description = "Schedule(일정) API")
@V1ApiController
class ScheduleController(
        private val scheduleService: ScheduleService
) {

    @ApiOperation(value = "전체 일정 조회")
    @GetMapping("/schedules")
    fun getSchedules(): ResponseEntity<ApiResponse<MutableList<Schedule>>> =
            ResponseEntity.ok(
                    ApiResponse(scheduleService.getSchedules())
            )


    @ApiOperation(value = "{id} 일정 조회")
    @GetMapping("/schedules/{id}")
    fun getSchedule(
            @ApiParam(value = "일정 PK", required = true) @PathVariable id: Int
    ): ResponseEntity<ApiResponse<Schedule>> =
            ResponseEntity.ok(
                    ApiResponse(scheduleService.getSchedule(id))
            )
}