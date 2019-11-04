package com.travelwith.api.model

import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedDate
import org.springframework.data.jpa.domain.support.AuditingEntityListener
import java.io.Serializable
import java.time.LocalDateTime
import javax.persistence.*


@MappedSuperclass
@EntityListeners(value = [AuditingEntityListener::class])
open class ImmutableEntity(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(columnDefinition = "INT UNSIGNED", nullable = false)
        open var id: Int? = null,

        @CreatedDate
        @Column(name = "created_at", columnDefinition = "DATETIME", nullable = false, updatable = false)
        open var createdAt: LocalDateTime = LocalDateTime.now()
): Serializable

@MappedSuperclass
@EntityListeners(value =[AuditingEntityListener::class])
open class MutableEntity(
        @LastModifiedDate
        @Column(name = "updated_at", columnDefinition = "DATETIME", nullable = true, updatable = true)
        open var updatedAt: LocalDateTime? = LocalDateTime.now()
): ImmutableEntity()
