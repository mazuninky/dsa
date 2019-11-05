package xyz.mazuninky.dsa.old.structure.list

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
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
