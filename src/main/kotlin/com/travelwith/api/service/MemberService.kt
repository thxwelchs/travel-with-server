package com.travelwith.api.service

import com.travelwith.api.model.Member
import com.travelwith.api.model.Schedule
import com.travelwith.api.model.ScheduleDTO
import com.travelwith.api.repository.MemberRepository
import com.travelwith.api.repository.TravelMemberRepository
import org.springframework.stereotype.Service

@Service
class MemberService(
        private val memberRepository: MemberRepository,
        private val scheduleService: ScheduleService
) {
    fun getMemberHasSchedules(memberId: Int): MutableList<ScheduleDTO> =
            scheduleService.getMemberHasSchedule(memberId)
}