package xyz.zerotwoone.algorithm.sort

import xyz.zerotwoone.algorithm.sorts.bubbleSortedArray
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class BubbleSortTest {

    @Test
    fun compareWithDefaultSort() {
        arrayOf(5, 3, 4, 9, 10, 2, 1, -5, -5, 10, 15, 34, 0).also {
            assertTrue(it.sortedArray()
                    .contentEquals(it.bubbleSortedArray()))
        }
    }
}