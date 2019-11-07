package xyz.mazuninky.dsa.algorithm

val IntRange.middle: Int
    get() = (start + endInclusive) / 2

fun <T> List<T>.binarySearch(item: T, comparator: Comparator<T>): Boolean {
    if (isEmpty())
        return false

    return binarySearchOn(item, comparator, IntRange(0, size))
}

fun <T> List<T>.binarySearchOn(item: T, comparator: Comparator<T>, range: IntRange): Boolean {
    val middle = range.middle
    val result = comparator.compare(item, get(middle))
    return when {
        result > 0 -> binarySearchOn(item, comparator, IntRange(middle, range.last))
        result < 0 -> binarySearchOn(item, comparator, IntRange(range.first, middle))
        else -> true
    }
}
