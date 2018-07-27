package xyz.zerotwoone.structure.map

import org.junit.Test
import kotlin.test.assertEquals

class HashMapTest {

    @Test
    fun setTest() {
        HashBSTMap<String, Int>(Char.MAX_HIGH_SURROGATE.toInt()) {
            when (it.length) {
                0 -> 0
                1 -> it[0].toInt()
                2 -> it[0].toInt() + it[1].toInt()
                3 -> it[0].toInt() + it[1].toInt() + it[2].toInt()
                else -> it[0].toInt() + it[it.length - 2].toInt() + it.last().toInt()
            }
        }.apply {
            set("aaaaa", 5)
            set("aaaaa", 5)
            assertEquals(5, get("aaaaa"))
            set("aaad", 15)
            set("alad", 25)
            assertEquals(15, get("aaad"))
            assertEquals(25, get("alad"))
        }
    }
}
