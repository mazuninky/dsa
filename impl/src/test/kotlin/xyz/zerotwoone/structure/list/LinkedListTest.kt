package xyz.zerotwoone.structure.list

import org.junit.Test

class LinkedListTest {
    @Test
    fun addTest() {
        val list = SingleLinkedList<Int>()
        val item = 1
        list.add(item)
        assert(item == list[0])
    }

    @Test(expected = IndexOutOfBoundsException::class)
    fun getTest() {
        val list = SingleLinkedList<Int>()
        list[2]
    }
}
