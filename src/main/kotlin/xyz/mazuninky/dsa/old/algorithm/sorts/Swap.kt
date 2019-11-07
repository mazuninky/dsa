package xyz.mazuninky.dsa.old.algorithm.sorts

inline fun <T> Array<T>.swap(first: Int, second: Int) {
    get(first).also {
        set(first, get(second))
        set(second, it)
    }
}