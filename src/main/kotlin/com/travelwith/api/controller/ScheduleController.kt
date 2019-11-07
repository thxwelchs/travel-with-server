package com.travelwith.api.controller

import com.travelwith.api.annotaion.V1ApiController
import com.travelwith.api.model.Schedule
import com.travelwith.api.repository.ScheduleRepository
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@V1ApiController
class ScheduleController(
        private val scheduleRepository: ScheduleRepository
) {
    @GetMapping("/schedules")
    fun getSchedules(): MutableList<Schedule> {
        return scheduleRepository.findAll()
    }
}