package com.travelwith.api.model.mapper

interface EntityMapper<E, D> {
    fun toDto(entity: E): D
    fun toEntity(dto: D): E
}