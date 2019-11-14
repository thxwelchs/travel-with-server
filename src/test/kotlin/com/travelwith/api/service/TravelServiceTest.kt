package com.travelwith.api.service

import com.travelwith.api.model.Travel
import com.travelwith.api.repository.TravelRepository
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import javax.persistence.EntityNotFoundException

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
internal class TravelServiceTest @Autowired constructor(
        private val travelRepository: TravelRepository
) {

    @Test
    fun `'getTravels'_여행_여러개_조회`() {
        //given
        val travelIds = arrayOf(1, 2, 3)

        //when
        val travels = travelRepository.findByIdIn(travelIds)

        //then
        assert(travels.size == 1)
    }

    @Test
    fun `'getTravel'_여행_아이디로_조회`() {
        //given
        val dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")

        val mockTravel = Travel().apply {
            id = 1
            name = "첫번째여행"
            travelExplain = "첫번째여행입니다."
            startDate = LocalDateTime.parse("2019-11-05 00:09:07", dateTimeFormatter)
            endDate = LocalDateTime.parse("2019-11-05 00:09:11", dateTimeFormatter)
            createdAt = LocalDateTime.parse("2019-11-04 15:09:14", dateTimeFormatter)
        }

        //when
        val travel = travelRepository.findById(1).orElseThrow { EntityNotFoundException() }

        //then
        assertEquals(mockTravel.name, travel.name)
        assertEquals(mockTravel.travelExplain, travel.travelExplain)
        assertEquals(mockTravel.startDate, travel.startDate)
        assertEquals(mockTravel.endDate, travel.endDate)
        assertEquals(mockTravel.createdAt, travel.createdAt)
    }

}