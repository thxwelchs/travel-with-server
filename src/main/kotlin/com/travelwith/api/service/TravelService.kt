package com.travelwith.api.service

import com.travelwith.api.model.Travel
import com.travelwith.api.model.TravelDTO
import com.travelwith.api.model.mapper.TravelMapper
import com.travelwith.api.repository.TravelMemberRepository
import com.travelwith.api.repository.TravelRepository
import org.springframework.stereotype.Service
import javax.persistence.EntityNotFoundException

@Service
class TravelService(
        private val travelRepository: TravelRepository,
        private val travelMemberRepository: TravelMemberRepository
) {

    private val travelMapper = TravelMapper.INSTANCE

    fun getTravels(): MutableList<TravelDTO> {
        val travels = travelRepository.findAll()

        return travelMapper.toDtoListWithoutLazy(travels)
    }

    fun getTravelsByIds(ids: Array<Int>): MutableList<Travel> {
        return travelRepository.findByIdIn(ids)
    }

    fun getTravel(id: Int): TravelDTO {
        val travel = travelRepository.findById(id).orElseThrow { EntityNotFoundException() }
        return travelMapper.toDtoWithoutLazy(travel)
    }
}