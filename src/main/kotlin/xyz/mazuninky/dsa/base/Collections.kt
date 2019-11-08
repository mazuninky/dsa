package xyz.mazuninky.dsa.base

interface DSACollection<T> : Iterable<T> {
    val size: Int
}

fun <T> DSACollection<T>.isEmpty(): Boolean {
    return size == 0
}

fun <T> DSACollection<T>.isNonEmpty(): Boolean {
    return size != 0
}

interface DSAList<T> : DSACollection<T> {
    operator fun get(index: Int): T
}

interface DSAMutableList<T> : DSAList<T> {
    operator fun set(index: Int, item: T)
}
