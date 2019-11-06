package com.travelwith.api.model

import com.fasterxml.jackson.annotation.JsonBackReference
import io.swagger.annotations.ApiModel
import java.time.LocalDateTime
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.JoinColumn
import javax.persistence.ManyToOne

@ApiModel
@Entity
data class Schedule(
        @ManyToOne
        @JoinColumn(name = "travel_id")
        @JsonBackReference
        var travel: Travel,

        var name: String,

        @Column(nullable = true)
        var scheduleExplain: String?,

        var placeName: String,

        @Column(nullable = true)
        var placeExplain: String?,

        @Column(nullable = true)
        var lon: Float?,

        @Column(nullable = true)
        var lat: Float?,

        @Column(nullable = true)
        var startDate: LocalDateTime?,

        @Column(nullable = true)
        var endDate: LocalDateTime?
): MutableEntity()