package xyz.zerotwoone.structure.list

import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFails
import kotlin.test.assertFailsWith

class LinkedListTest {
    @Test
    fun addTest() {
        SingleLinkedList<Int>().apply {
            val item = 1
            add(item)
            assertEquals(item, get(0))
        }
    }

    @Test
    fun getTest() {
        assertFailsWith(IndexOutOfBoundsException::class) {
            SingleLinkedList<Int>().apply {
                get(2)
            }
        }
    }
}
