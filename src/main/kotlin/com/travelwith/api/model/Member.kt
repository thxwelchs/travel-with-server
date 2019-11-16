package com.travelwith.api.model

import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.annotation.JsonManagedReference
import io.swagger.annotations.ApiModel
import javax.persistence.*

@ApiModel
@Entity
data class Member(
        var memberId: String,

        @JsonIgnore
        var memberPw: String,

        var name: String,

        var nickname: String,

        @Column(nullable = true)
        var snsType: Short?,

        @Column(nullable = true)
        var black: Boolean?,

        @Column(nullable = true)
        var memberType: Short?,

        @Column(nullable = true)
        var dormant: Boolean?,

        @OneToOne(mappedBy = "member", fetch = FetchType.LAZY)
        var memberActivity: MemberActivity?,

        @OneToMany(mappedBy = "member", fetch = FetchType.LAZY)
        @JsonManagedReference
        var scheduleMembers: MutableSet<ScheduleMember>? = HashSet(),

        @OneToMany(mappedBy = "member", fetch = FetchType.LAZY)
        @JsonManagedReference
        var travelMembers: MutableSet<TravelMember>? = HashSet(),

        @OneToMany(mappedBy = "member", fetch = FetchType.LAZY)
        @JsonManagedReference
        var coupons: MutableList<Coupon>? = ArrayList()
): MutableEntity()