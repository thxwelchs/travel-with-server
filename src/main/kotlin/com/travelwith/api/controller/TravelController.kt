package com.travelwith.api.controller

import com.travelwith.api.annotaion.V1ApiController
import com.travelwith.api.model.Travel
import com.travelwith.api.repository.TravelRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@V1ApiController
class TravelController(
        private val travelRepository: TravelRepository
) {

    @GetMapping("/travels")
    fun getTravels(): MutableList<Travel> {
        return travelRepository.findAll()
    }
}