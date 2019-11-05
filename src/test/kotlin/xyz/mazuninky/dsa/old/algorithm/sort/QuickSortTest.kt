package xyz.mazuninky.dsa.old.algorithm.sort

import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import xyz.mazuninky.dsa.old.algorithm.sorts.quickSortedArray

class QuickSortTest {
    @Test
    fun compareWithDefaultSort() {
        arrayOf(5, 3, 4, 9, 10, 2, 1, -5, -5, 10, 15, 34, 0).also {
            assertTrue(it.sortedArray()
                    .contentEquals(it.quickSortedArray()))
        }
    }
}
