package com.doanda.melodify.core.utils

import com.doanda.melodify.dummy_data.testTrack
import com.doanda.melodify.dummy_data.testTrackEntity
import com.doanda.melodify.dummy_data.testTrackResponse
import org.junit.Test
import org.junit.jupiter.api.Assertions.*

class DataMapperTest {

    @Test
    fun mapResponsesToEntities_ReturnsCorrectFormat() {
        val result = DataMapper.mapResponsesToEntities(listOf(testTrackResponse))
        assertEquals(listOf(testTrackEntity), result)
    }

    @Test
    fun mapEntitiesToDomain_ReturnsCorrectFormat() {
        val result = DataMapper.mapEntitiesToDomain(listOf(testTrackEntity))
        assertEquals(listOf(testTrack), result)
    }

    @Test
    fun mapDomainToEntity_ReturnsCorrectFormat() {
        val result = DataMapper.mapDomainToEntity(testTrack)
        assertEquals(testTrackEntity, result)
    }
}