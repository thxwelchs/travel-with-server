package com.travelwith.api.repository

import com.travelwith.api.model.Travel
import org.springframework.data.jpa.repository.JpaRepository

interface TravelRepository: JpaRepository<Travel, Int> {
    fun findByIdIn(ids: Array<Int>): MutableList<Travel>
}