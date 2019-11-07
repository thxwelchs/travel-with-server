package com.travelwith.api.model

import com.fasterxml.jackson.annotation.JsonManagedReference
import io.swagger.annotations.ApiModel
import java.time.LocalDateTime
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.OneToMany

@ApiModel
@Entity
data class Travel(
        var name: String,

        @Column(nullable = true)
        var travelExplain: String?,

        var startDate: LocalDateTime,

        @Column(nullable = true)
        var endDate: LocalDateTime?,

        @OneToMany(mappedBy = "travel")
        @JsonManagedReference
        var schedules: MutableList<Schedule>? = ArrayList()
): MutableEntity()