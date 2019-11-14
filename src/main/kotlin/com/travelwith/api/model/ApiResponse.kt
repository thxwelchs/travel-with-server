package com.travelwith.api.model

import io.swagger.annotations.ApiModel
import org.springframework.http.HttpStatus

/**
 * Api 요청에 대한 응답 객체를 정의
 */

class ApiResponse<T>(private val t: T){
        var data: T? = t
        var httpStatus: HttpStatus = HttpStatus.OK
        var message: String = ""
        var error: ApiResponseError? = null
}

data class ApiResponseError(
        var errorCode: ErrorCode,
        var errorMessage: String
)