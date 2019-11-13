package com.travelwith.api.model

import org.springframework.http.HttpStatus

/**
 * Api 요청에 대한 응답 객체를 정의
 */

data class ApiResponse(
        var httpStatus: HttpStatus = HttpStatus.OK,
        var message: String = "",
        var error: ApiResponseError? = null
)

data class ApiResponseError(
        var errorCode: String,
        var errorMessage: String
)