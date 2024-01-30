package com.doanda.melodify.core.utils

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
}