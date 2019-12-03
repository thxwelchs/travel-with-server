package com.travelwith.api.model

import com.fasterxml.jackson.annotation.JsonManagedReference
import io.swagger.annotations.ApiModel
import java.time.LocalDateTime
import javax.persistence.FetchType
import javax.persistence.OneToMany

@ApiModel
data class TravelDTO (
        var name: String = "",
        var explain: String? = null,
        var startDate: LocalDateTime = LocalDateTime.now(),
        var endDate: LocalDateTime? = null,
        var schedules: MutableList<ScheduleDTO>? = ArrayList(),
        var members: MutableList<MemberDTO> = ArrayList()
): MutableDTO()