package com.travelwith.api.controller

import com.travelwith.api.annotaion.V1ApiController
import com.travelwith.api.model.ApiResponse
import com.travelwith.api.model.Travel
import com.travelwith.api.model.TravelDTO
import com.travelwith.api.repository.TravelRepository
import com.travelwith.api.service.TravelService
import io.swagger.annotations.Api
import io.swagger.annotations.ApiOperation
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable

@Api(description = "Travel(여행) API")
@V1ApiController
class TravelController(
        private val travelService: TravelService
) {

    @ApiOperation("모든 여행 조회")
    @GetMapping("/travels")
    fun getTravels(): ResponseEntity<ApiResponse<MutableList<TravelDTO>>> =
        ResponseEntity.ok(
                ApiResponse(travelService.getTravels())
        )

    @ApiOperation("여행 조회")
    @GetMapping("/travels/{travelId}")
    fun getTravel(@PathVariable travelId: Int): ResponseEntity<ApiResponse<TravelDTO>> =
            ResponseEntity.ok(
                    ApiResponse(travelService.getTravel(travelId))
            )
}