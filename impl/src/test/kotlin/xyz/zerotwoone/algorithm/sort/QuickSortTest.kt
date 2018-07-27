package xyz.zerotwoone.algorithm.sort

import org.junit.Test
import xyz.zerotwoone.algorithm.sorts.quickSortedArray

class QuickSortTest {
    @Test
    fun compareWithDefaultSort() {
        arrayOf(5, 3, 4, 9, 10, 2, 1, -5, -5, 10, 15, 34, 0).also {
            assert(it.sortedArray()
                    .contentEquals(it.quickSortedArray()))
        }
    }
}
