package com.travelwith.api.annotaion

import org.springframework.core.annotation.AliasFor
import org.springframework.stereotype.Component
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@Target(AnnotationTarget.CLASS, AnnotationTarget.FILE)
@Retention(AnnotationRetention.RUNTIME)
@RestController
@RequestMapping("/api/v1")
annotation class V1ApiController(
        @get:AliasFor(annotation = Component::class, attribute = "value")
        val value: String = ""
)
