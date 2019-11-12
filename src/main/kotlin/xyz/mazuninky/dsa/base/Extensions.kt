package xyz.mazuninky.dsa.base

fun <T> DSACollection<T>.isEmpty(): Boolean {
    return size == 0
}

fun <T> DSACollection<T>.isNonEmpty(): Boolean {
    return size != 0
}

fun <T> DSAList<T>.first(): T {
    check(isNonEmpty())
    return get(0)
}

fun <T> DSAList<T>.last(): T {
    check(isNonEmpty())

    if (size == 1)
        return get(0)

    return get(size - 1)
}

fun <T> DSAMutableList<T>.removeFirst(): T {
    check(isNonEmpty())
    return remove(0)
}
