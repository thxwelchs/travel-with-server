package com.travelwith.api.model

import com.fasterxml.jackson.annotation.JsonBackReference
import com.fasterxml.jackson.annotation.JsonManagedReference
import io.swagger.annotations.ApiModel
import java.io.Serializable
import java.time.LocalDateTime
import javax.persistence.*

@ApiModel
@Entity
data class Schedule(
        @ManyToOne(fetch = FetchType.LAZY)
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
        var endDate: LocalDateTime?,

        @OneToMany(mappedBy = "schedule", fetch = FetchType.LAZY)
        @JsonManagedReference
        var scheduleMembers: MutableList<ScheduleMember>? = null
): MutableEntity(), Serializable