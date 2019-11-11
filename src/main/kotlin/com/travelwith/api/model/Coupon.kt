package com.travelwith.api.model

import io.swagger.annotations.ApiModel
import javax.persistence.Entity

@ApiModel
@Entity
data class Coupon (
        var member: Member,
        var couponUuid: ByteArray,
        var use: Boolean,
        var retire: Boolean
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Coupon

        if (member != other.member) return false
        if (!couponUuid.contentEquals(other.couponUuid)) return false

        return true
    }

    override fun hashCode(): Int {
        var result = member.hashCode()
        result = 31 * result + couponUuid.contentHashCode()
        return result
    }
}