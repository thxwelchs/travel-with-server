package com.travelwith.api.model

import com.fasterxml.jackson.annotation.JsonManagedReference
import io.swagger.annotations.ApiModel
import java.time.LocalDateTime
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.FetchType
import javax.persistence.OneToMany

@ApiModel
@Entity
data class Travel(
        var name: String = "",

        @Column(nullable = true)
        var travelExplain: String? = null,

        var startDate: LocalDateTime = LocalDateTime.now(),

        @Column(nullable = true)
        var endDate: LocalDateTime? = null,

        @OneToMany(mappedBy = "travel", fetch = FetchType.LAZY)
        @JsonManagedReference
        var schedules: MutableList<Schedule>? = ArrayList(),

        @OneToMany(mappedBy = "member", fetch = FetchType.LAZY)
        @JsonManagedReference
        var travelMembers: MutableList<TravelMember>? = ArrayList()
): MutableEntity()