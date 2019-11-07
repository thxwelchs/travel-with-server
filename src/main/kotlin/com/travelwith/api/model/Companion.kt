package com.travelwith.api.model

import com.fasterxml.jackson.annotation.JsonBackReference
import com.fasterxml.jackson.annotation.JsonIgnore
import io.swagger.annotations.ApiModel
import javax.persistence.Entity
import javax.persistence.FetchType
import javax.persistence.JoinColumn
import javax.persistence.ManyToOne

@ApiModel
@Entity
data class Companion(

        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "schedule_id")
        @JsonBackReference
        var schedule: Schedule,

        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "member_id")
//        @JsonBackReference
        var member: Member
): MutableEntity()