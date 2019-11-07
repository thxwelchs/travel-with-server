package com.travelwith.api.repository

import com.travelwith.api.model.Schedule
import org.springframework.data.jpa.repository.JpaRepository

interface ScheduleRepository: JpaRepository<Schedule, Int>