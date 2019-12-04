package com.travelwith.api.model

import io.swagger.annotations.ApiModel
import org.mapstruct.Mapper
import java.time.LocalDateTime

@ApiModel
data class ScheduleDTO (
        var name: String = "",
        var scheduleExplain: String? = null,
        var placeName: String = "",
        var placeExplain: String? = null,
        var lon: Float? = null,
        var lat: Float? = null,
        var startDate: LocalDateTime? = null,
        var endDate: LocalDateTime? = null
//        var travel: Any? = null
): MutableDTO() {
    constructor(id: Int, name: String, scheduleExplain: String?,
                placeName: String, placeExplain: String?,
                lon: Float?, lat: Float?,
                startDate: LocalDateTime?, endDate: LocalDateTime?,
                createdAt: LocalDateTime, updatedAt: LocalDateTime?) : this() {
        this.id = id
        this.name = name
        this.scheduleExplain = scheduleExplain
        this.placeName = placeName
        this.placeExplain = placeExplain
        this.lon = lon
        this.lat = lat
        this.startDate = startDate
        this.endDate = endDate
        this.createdAt = createdAt
        this.updatedAt = updatedAt
    }
}
