package xyz.zerotwoone.algorithm.statistics

import kotlin.test.Test
import kotlin.test.assertEquals

class StandardDeviationTest {
    @Test
    fun testStandardDeviation() {
        val valueSequence: List<Int> = listOf(0, 6, 8, 14)
        val s = valueSequence.standardDeviation()
        assertEquals(5.0, s)
    }
}