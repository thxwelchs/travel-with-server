package com.travelwith.api.controller

import com.travelwith.api.model.ApiResponse
import com.travelwith.api.model.ApiResponseError
import com.travelwith.api.model.ErrorCode
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice
import javax.servlet.http.HttpServletRequest

@RestControllerAdvice
class ApiControllerAdvice {

    @ExceptionHandler(Exception::class)
    fun internalServerException(httpServletRequest: HttpServletRequest, e: Exception): ResponseEntity<ApiResponse<String>> {
        val httpStatusCode = HttpStatus.INTERNAL_SERVER_ERROR

        val apiResponse = ApiResponse("").apply {
            httpStatus = httpStatusCode
            message = e.message.toString()
            error = ApiResponseError(ErrorCode.INTERNAL_SERVER_ERROR, e.message.toString())
        }

        return ResponseEntity(apiResponse, HttpStatus.INTERNAL_SERVER_ERROR)
    }

}