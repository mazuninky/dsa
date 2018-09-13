package xyz.zerotwoone.algorithm.sort

import xyz.zerotwoone.algorithm.sorts.quickSortedArray
import kotlin.test.Test
import kotlin.test.assertTrue

class QuickSortTest {
    @Test
    fun compareWithDefaultSort() {
        arrayOf(5, 3, 4, 9, 10, 2, 1, -5, -5, 10, 15, 34, 0).also {
            assertTrue(it.sortedArray()
                    .contentEquals(it.quickSortedArray()))
        }
    }
}
