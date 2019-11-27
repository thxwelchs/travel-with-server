package com.travelwith.api.repository

import com.travelwith.api.model.Member
import com.travelwith.api.model.Travel
import com.travelwith.api.model.TravelMember
import org.springframework.data.jpa.repository.JpaRepository

interface TravelMemberRepository: JpaRepository<TravelMember, Int> {
    fun findByTravel(travel: Travel): MutableList<TravelMember>
    fun findByMember(member: Member): MutableList<TravelMember>
}