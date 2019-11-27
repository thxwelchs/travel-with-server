package com.travelwith.api.service

import com.travelwith.api.model.Travel
import com.travelwith.api.model.TravelDTO
import com.travelwith.api.repository.TravelMemberRepository
import com.travelwith.api.repository.TravelRepository
import org.springframework.stereotype.Service
import javax.persistence.EntityNotFoundException

@Service
class TravelService(
        private val travelRepository: TravelRepository,
        private val travelMemberRepository: TravelMemberRepository
) {
    fun getTravels(): MutableList<Travel> {
        return travelRepository.findAll()
    }

    fun getTravelsByIds(ids: Array<Int>): MutableList<Travel> {
        return travelRepository.findByIdIn(ids)
    }

    fun getTravel(id: Int): Travel {
        return travelRepository.findById(id).orElseThrow { EntityNotFoundException() }
    }
}