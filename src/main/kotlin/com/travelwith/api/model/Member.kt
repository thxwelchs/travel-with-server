package com.travelwith.api.model

import com.fasterxml.jackson.annotation.JsonIgnore
import io.swagger.annotations.ApiModel
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.OneToOne

@ApiModel
@Entity
data class Member(
        var memberId: String,

        @JsonIgnore
        var memberPw: String,

        var name: String,

        var nickname: String,

        @Column(nullable = true)
        var snsType: Integer?,

        @Column(nullable = true)
        var black: Boolean?,

        @Column(nullable = true)
        var memberType: Integer?,

        @Column(nullable = true)
        var dormant: Boolean?,

        @OneToOne(mappedBy = "member")
        var memberActivity: MemberActivity?
): MutableEntity()