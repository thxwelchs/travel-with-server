package com.travelwith.api.model

import io.swagger.annotations.ApiModel
import java.time.LocalDateTime

@ApiModel
data class TravelDTO (
        var name: String = "",
        var explain: String? = null,
        var startDate: LocalDateTime = LocalDateTime.now(),
        var endDate: LocalDateTime? = null,
        var members: MutableSet<Member> = HashSet()
): MutableDTO()