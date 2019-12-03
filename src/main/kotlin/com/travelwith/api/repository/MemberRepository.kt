package com.travelwith.api.repository

import com.travelwith.api.model.Member
import org.springframework.data.jpa.repository.JpaRepository

interface MemberRepository: JpaRepository<Member, Int> {
    fun findByMemberId(memberId: String): Member
}