package com.travelwith.api.model

import com.fasterxml.jackson.annotation.JsonBackReference
import io.swagger.annotations.ApiModel
import javax.persistence.*

@ApiModel
@Entity
data class MemberActivity(
        @OneToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "member_id")
        @JsonBackReference
        var member: Member,

        @Column(nullable = true)
        var like: Int?,

        @Column(nullable = true)
        var hate: Int?
): MutableEntity()