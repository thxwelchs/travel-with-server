package com.travelwith.api.model

import io.swagger.annotations.ApiModel
import org.mapstruct.Mapper
import java.time.LocalDateTime

@ApiModel
class ScheduleDTO {
        data class BaseDTO(
                var id: Int = 0,
                var name: String = "",
                var travel: Travel? = null,
                var scheduleExplain: String? = null,
                var placeName: String = "",
                var placeExplain: String? = null,
                var lon: Float? = null,
                var lat: Float? = null,
                var startDate: LocalDateTime? = null,
                var endDate: LocalDateTime? = null,
                var createdAt: LocalDateTime,
                var updatedAt: LocalDateTime? = null
        )

}
