package xyz.zerotwoone.structure.list

import org.junit.Test

class LinkedListTest {
    @Test
    fun addTest() {
        SingleLinkedList<Int>().apply {
            val item = 1
            add(item)
            assert(item == get(0))
        }
    }

    @Test(expected = IndexOutOfBoundsException::class)
    fun getTest() {
        SingleLinkedList<Int>().apply {
            get(2)
        }
    }
}
