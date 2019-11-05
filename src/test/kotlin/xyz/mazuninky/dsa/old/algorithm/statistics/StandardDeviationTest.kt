package xyz.mazuninky.dsa.old.algorithm.statistics

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test


class StandardDeviationTest {
    @Test
    fun testStandardDeviation() {
        val valueSequence: List<Int> = listOf(0, 6, 8, 14)
        val s = valueSequence.standardDeviation()
        assertEquals(5.0, s)
    }
}
