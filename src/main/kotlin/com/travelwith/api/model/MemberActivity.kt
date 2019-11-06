package com.travelwith.api.model

import com.fasterxml.jackson.annotation.JsonBackReference
import io.swagger.annotations.ApiModel
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.JoinColumn
import javax.persistence.OneToOne

@ApiModel
@Entity
data class MemberActivity(
        @OneToOne
        @JoinColumn(name = "member_id")
        @JsonBackReference
        var member: Member,

        @Column(nullable = true)
        var like: Integer?,

        @Column(nullable = true)
        var hate: Integer?
)