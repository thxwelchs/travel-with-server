package com.travelwith.api.service

import com.travelwith.api.model.Member
import com.travelwith.api.model.MemberDTO
import com.travelwith.api.model.Schedule
import com.travelwith.api.model.ScheduleDTO
import com.travelwith.api.model.mapper.MemberMapper
import com.travelwith.api.repository.MemberRepository
import com.travelwith.api.repository.TravelMemberRepository
import org.springframework.stereotype.Service

@Service
class MemberService(
        private val memberRepository: MemberRepository,
        private val scheduleService: ScheduleService
) {

    private val memberMapper = MemberMapper.INSTANCE

    fun getMember(memberId: String): MemberDTO {
        val member = memberRepository.findByMemberId(memberId)
        return memberMapper.toDto(member)
    }
    fun getMemberHasSchedules(memberId: String): MutableList<ScheduleDTO> =
            scheduleService.getMemberHasSchedule(memberId)
}