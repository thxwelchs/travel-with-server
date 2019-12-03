package com.travelwith.api.model

data class MemberDTO (
        var memberId: String? = "",
        var name: String? = "",
        var nickname: String? = "",
        var snsType: Short? = 0,
        var black: Boolean? = false,
        var memberType: Short? = 0,
        var dormant: Boolean? = false
//        var scheduleMembers: MutableList<ScheduleMember>? = ArrayList(),
//        var travelMembers: MutableList<TravelMember>? = ArrayList(),
//        var coupons: MutableList<Coupon>? = ArrayList()
): MutableDTO()