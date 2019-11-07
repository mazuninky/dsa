package xyz.mazuninky.dsa.algorithm

import xyz.mazuninky.dsa.base.KList
import xyz.mazuninky.dsa.base.isEmpty

val IntRange.middle: Int
    get() = (start + endInclusive) / 2

/**
 * Binary search
 * O(log n)
 */
fun <T> KList<T>.binarySearch(item: T, comparator: Comparator<T>): Boolean {
    if (isEmpty())
        return false

    return binarySearchOn(item, comparator, IntRange(0, size))
}

fun <T> KList<T>.binarySearchOn(item: T, comparator: Comparator<T>, range: IntRange): Boolean {
    val middle = range.middle
    val result = comparator.compare(item, get(middle))
    return result.run {
        when {
            this > 0 -> binarySearchOn(item, comparator, IntRange(middle, range.last))
            this < 0 -> binarySearchOn(item, comparator, IntRange(range.first, middle))
            else -> true
        }
    }
}
