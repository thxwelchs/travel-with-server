package com.travelwith.api.controller

import com.travelwith.api.annotaion.V1ApiController
import com.travelwith.api.model.Travel
import com.travelwith.api.repository.TravelRepository
import io.swagger.annotations.Api
import io.swagger.annotations.ApiOperation
import org.springframework.web.bind.annotation.GetMapping

@Api(description = "Travel(여행) API")
@V1ApiController
class TravelController(
        private val travelRepository: TravelRepository
) {

    @ApiOperation("모든 여행 조회")
    @GetMapping("/travels")
    fun getTravels(): MutableList<Travel> {
        return travelRepository.findAll()
    }
}