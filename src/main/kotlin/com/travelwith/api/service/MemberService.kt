package com.travelwith.api.service

import com.travelwith.api.model.Member
import com.travelwith.api.repository.MemberRepository
import com.travelwith.api.repository.TravelMemberRepository
import org.springframework.stereotype.Service

@Service
class MemberService(
        private val travelService: TravelService,
        private val memberRepository: MemberRepository,
        private val travelMemberRepository: TravelMemberRepository
) {
    fun findMembersByTravelId(travelId: Int): MutableList<Member> {
        val travel = travelService.getTravel(travelId)

        val travelMembers = travelMemberRepository.findByTravel(travel)

        val members: MutableList<Member> = ArrayList()

        travelMembers.forEach { tm ->
            members.add(tm.member)
        }
        return members
    }

}