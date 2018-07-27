package xyz.zerotwoone.structure.map

import org.junit.Test
import kotlin.test.assertEquals

class HashMapTest {

    @Test
    fun setTest() {
        val map = HashBSTMap<String, Int>(Char.MAX_HIGH_SURROGATE.toInt()) {
            when (it.length) {
                0 -> 0
                1 -> it[0].toInt()
                2 -> it[0].toInt() + it[1].toInt()
                3 -> it[0].toInt() + it[1].toInt() + it[2].toInt()
                else -> it[0].toInt() + it[it.length - 2].toInt() + it.last().toInt()
            }
        }
        map.set("aaaaa", 5)
        map.set("aaaaa", 5)
        assertEquals(5, map.get("aaaaa"))
        map.set("aaad", 15)
        map.set("alad", 25)
        assertEquals(15, map.get("aaad"))
        assertEquals(25, map.get("alad"))
    }
}
