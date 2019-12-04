package com.travelwith.api.repository

import com.querydsl.core.types.Projections
import com.querydsl.jpa.JPQLQuery
import com.travelwith.api.model.*
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport

interface TravelRepository: JpaRepository<Travel, Int>, TravelRepositoryCustom {
    fun findByIdIn(ids: Array<Int>): MutableList<Travel>
}

interface TravelRepositoryCustom {
    fun findTravelsByMemberId(memberId: String): MutableList<TravelDTO>
}

class TravelRepositoryImpl: TravelRepositoryCustom, QuerydslRepositorySupport(Travel::class.java) {
    override fun findTravelsByMemberId(memberId: String): MutableList<TravelDTO> {
        val qTravel = QTravel.travel
        val qMember = QMember.member
        val qTravelMember = QTravelMember.travelMember

        return from(qTravel)
                .select(Projections.constructor(TravelDTO::class.java,
                        qTravel.id,
                        qTravel.name,
                        qTravel.travelExplain,
                        qTravel.startDate,
                        qTravel.endDate,
                        qTravel.createdAt,
                        qTravel.updatedAt
                        ))
                .join(qTravelMember).on(qTravelMember.travel.id.eq(qTravel.id))
                .join(qMember).on(qMember.id.eq(qTravelMember.member.id).and(qMember.memberId.eq(memberId)))
                .fetch()
    }
}