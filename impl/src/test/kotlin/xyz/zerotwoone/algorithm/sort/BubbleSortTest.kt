package xyz.zerotwoone.algorithm.sort

import org.junit.Test
import xyz.zerotwoone.algorithm.sorts.bubbleSortedArray

class BubbleSortTest {
    @Test
    fun compareWithDefaultSort() {
        val array = arrayOf(5, 3, 4, 9, 10, 2, 1, -5, -5, 10, 15, 34, 0)
        assert(array.sortedArray()
                .contentEquals(array.bubbleSortedArray()))
    }
}