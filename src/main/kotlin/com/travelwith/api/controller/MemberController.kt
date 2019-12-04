package com.travelwith.api.controller

import com.travelwith.api.annotaion.V1ApiController
import com.travelwith.api.model.*
import com.travelwith.api.service.MemberService
import io.swagger.annotations.Api
import io.swagger.annotations.ApiOperation
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable

@Api(description = "Member(회원) API")
@V1ApiController
class MemberController(
        private val memberService: MemberService
) {
    @ApiOperation(value = "{memberId} 회원아이디로 회원 조회")
    @GetMapping("/members/{memberId}")
    fun getMember(@PathVariable memberId: String): ResponseEntity<ApiResponse<MemberDTO>> =
            ResponseEntity.ok(
                    ApiResponse(memberService.getMember(memberId))
            )

    @ApiOperation(value = "{memberId} 회원아이디로 여행 조회")
    @GetMapping("/members/{memberId}/travels")
    fun getMemberHasTravels(@PathVariable memberId: String): ResponseEntity<ApiResponse<MutableList<TravelDTO>>> =
            ResponseEntity.ok(
                    ApiResponse(memberService.getMemberHasTravels(memberId))
            )

    @ApiOperation(value = "{memberId} 회원아이디로 일정 조회")
    @GetMapping("/members/{memberId}/schedules")
    fun getMemberHasSchedules(@PathVariable memberId: String): ResponseEntity<ApiResponse<MutableList<ScheduleDTO>>> =
            ResponseEntity.ok(
                    ApiResponse(memberService.getMemberHasSchedules(memberId))
            )


}