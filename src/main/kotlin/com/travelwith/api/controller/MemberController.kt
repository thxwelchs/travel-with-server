package com.travelwith.api.controller

import com.travelwith.api.annotaion.V1ApiController
import com.travelwith.api.model.ApiResponse
import com.travelwith.api.model.Schedule
import com.travelwith.api.model.ScheduleDTO
import com.travelwith.api.service.MemberService
import io.swagger.annotations.Api
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable

@Api(description = "Member(회원) API")
@V1ApiController
class MemberController(
        private val memberService: MemberService
) {
    @GetMapping("/members/{memberId}/schedules")
    fun getMemberHasSchedules(@PathVariable memberId: Int): ResponseEntity<ApiResponse<MutableList<ScheduleDTO.BaseDTO>>> =
            ResponseEntity.ok(
                    ApiResponse(memberService.getMemberHasSchedules(memberId))
            )
}