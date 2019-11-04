package com.travelwith.api.model

import java.time.LocalDateTime
import javax.persistence.Column
import javax.persistence.Entity

@Entity(name = "travel")
class Travel(
        var name: String,

        @Column(name = "travel_explain", nullable = true)
        var travelExplain: String?,

        @Column(name = "start_date")
        var startDate: LocalDateTime,

        @Column(name = "end_date", nullable = true)
        var endDate: LocalDateTime?
): MutableEntity()