package com.travelwith.api.model

import com.fasterxml.jackson.annotation.JsonBackReference
import io.swagger.annotations.ApiModel
import org.hibernate.annotations.GenericGenerator
import java.util.*
import javax.persistence.*

@ApiModel
@Entity
data class Coupon (
        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "member_id")
        @JsonBackReference
        var member: Member,

//        @GenericGenerator(name = "uuid2", strategy = "uuid2")
        @Column(columnDefinition = "BINARY(16)")
        var couponUuid: ByteArray,

        var use: Boolean,
        var retire: Boolean
): MutableEntity() {
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