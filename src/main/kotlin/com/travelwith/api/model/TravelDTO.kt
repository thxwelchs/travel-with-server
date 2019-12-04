package com.travelwith.api.model

import com.fasterxml.jackson.annotation.JsonManagedReference
import io.swagger.annotations.ApiModel
import java.time.LocalDateTime
import javax.persistence.FetchType
import javax.persistence.OneToMany

@ApiModel
data class TravelDTO (
        var name: String = "",
        var travelExplain: String? = null,
        var startDate: LocalDateTime = LocalDateTime.now(),
        var endDate: LocalDateTime? = null,
        var schedules: MutableList<ScheduleDTO>? = ArrayList(),
        var members: MutableList<MemberDTO> = ArrayList()
): MutableDTO() {
    constructor(id: Int,
                name: String,
                travelExplain: String?,
                startDate: LocalDateTime,
                endDate: LocalDateTime?,
                createdAt: LocalDateTime,
                updatedAt: LocalDateTime?): this() {
        this.id = id
        this.name = name
        this.travelExplain = travelExplain
        this.startDate = startDate
        this.endDate = endDate
        this.createdAt = createdAt
        this.updatedAt = updatedAt
    }
}