package xyz.mazuninky.dsa.base

interface KCollection<T> : Iterable<T> {
    val size: Int
}

fun <T> KCollection<T>.isEmpty(): Boolean {
    return size == 0
}

fun <T> KCollection<T>.isNonEmpty(): Boolean {
    return size != 0
}

interface KList<T> : KCollection<T> {
    operator fun get(index: Int): T
}
