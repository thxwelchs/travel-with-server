package com.travelwith.api.model

import com.fasterxml.jackson.annotation.JsonBackReference
import io.swagger.annotations.ApiModel
import javax.persistence.Entity
import javax.persistence.FetchType
import javax.persistence.JoinColumn
import javax.persistence.ManyToOne

@ApiModel
@Entity
data class TravelMember (
        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "travel_id")
        @JsonBackReference
        var travel: Travel,

        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "member_id")
//        @JsonBackReference
        var member: Member
): MutableEntity()