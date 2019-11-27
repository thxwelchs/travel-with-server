package com.travelwith.api.model

import io.swagger.annotations.ApiModel
import org.mapstruct.Mapper
import java.time.LocalDateTime

@ApiModel
class ScheduleDTO (
        var id: Int,
        var name: String,
        var travel: Travel?,
        var scheduleExplain: String?,
        var placeName: String,
        var placeExplain: String?,
        var lon: Float?,
        var lat: Float?,
        var startDate: LocalDateTime?,
        var endDate: LocalDateTime?,
        var createdAt: LocalDateTime,
        var updatedAt: LocalDateTime?
) {
    constructor() : this(0,
            "",
            null,
            null,
            "",
            null,
            null,
            null,
            null,
            null,
            LocalDateTime.now(),
            null)
}
