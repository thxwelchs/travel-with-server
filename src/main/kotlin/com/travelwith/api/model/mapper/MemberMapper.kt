package com.travelwith.api.model.mapper

import com.travelwith.api.model.Member
import com.travelwith.api.model.MemberDTO
import org.mapstruct.Mapper
import org.mapstruct.Mapping
import org.mapstruct.factory.Mappers

@Mapper(
        componentModel = "spring"
)
interface MemberMapper {
    companion object {
        val INSTANCE = Mappers.getMapper(MemberMapper::class.java)
    }

    fun toDto(entity: Member): MemberDTO
}