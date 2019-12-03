package com.travelwith.api.model.mapper

import com.travelwith.api.model.Travel
import com.travelwith.api.model.TravelDTO
import org.mapstruct.*
import org.mapstruct.factory.Mappers

@Mapper(
        componentModel = "spring"
)
interface TravelMapper {
    companion object {
        val INSTANCE = Mappers.getMapper(TravelMapper::class.java)
    }

//    @Mappings(
//        Mapping(target = " schedules", ignore = true),
//        Mapping(target = " travelMembers", ignore = true)
//    )
    @Mapping(target = "schedules", ignore = true)
    @Named("toDtoTravelWithoutLazy")
    fun toDtoWithoutLazy(entity: Travel): TravelDTO

    @IterableMapping(qualifiedByName = ["toDtoTravelWithoutLazy"])
    fun toDtoListWithoutLazy(entities: MutableList<Travel>): MutableList<TravelDTO>
}