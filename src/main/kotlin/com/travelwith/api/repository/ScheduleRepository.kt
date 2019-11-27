package com.travelwith.api.repository

import com.querydsl.core.types.Projections
import com.travelwith.api.model.*
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport

interface ScheduleRepository: JpaRepository<Schedule, Int>, ScheduleRepositoryCustom

interface ScheduleRepositoryCustom {
    fun findMemberHasSchedules(memberId: Int): MutableList<ScheduleDTO>
}

class ScheduleRepositoryImpl: ScheduleRepositoryCustom, QuerydslRepositorySupport(Schedule::class.java) {
    override fun findMemberHasSchedules(memberId: Int): MutableList<ScheduleDTO> {
        val qSchedule = QSchedule.schedule
        val qScheduleMember = QScheduleMember.scheduleMember

        return from(qSchedule)
                .select(Projections.constructor(ScheduleDTO::class.java,
                        qSchedule.id,
                        qSchedule.name,
                        qSchedule.scheduleExplain,
                        qSchedule.placeName,
                        qSchedule.placeExplain,
                        qSchedule.lon,
                        qSchedule.lat,
                        qSchedule.startDate,
                        qSchedule.endDate,
                        qSchedule.createdAt,
                        qSchedule.updatedAt
                        ))
                .join(qScheduleMember)
                .on(qScheduleMember.schedule.id.eq(qSchedule.id))
                .where(qScheduleMember.member.id.eq(memberId))
                .fetch()
    }
}