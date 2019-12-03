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
        var dormant: Boolean?

//        @OneToOne(fetch = FetchType.EAGER)
//        @JoinColumn(name = "memberId", insertable = false, updatable = false)
//        var memberActivity: MemberActivity?,
//
//        @OneToMany(mappedBy = "member", fetch = FetchType.LAZY)
//        @JsonManagedReference
//        var scheduleMembers: MutableList<ScheduleMember>? = ArrayList(),
//
//        @OneToMany(mappedBy = "member", fetch = FetchType.LAZY)
//        @JsonManagedReference
//        var travelMembers: MutableList<TravelMember>? = ArrayList(),
//
//        @OneToMany(mappedBy = "member", fetch = FetchType.LAZY)
//        @JsonManagedReference
//        var coupons: MutableList<Coupon>? = ArrayList()
): MutableEntity()