package xyz.zerotwoone.algorithm.sorts

@Suppress("NOTHING_TO_INLINE")
inline fun <T> Array<T>.swap(first: Int, second: Int) {
    get(first).also {
        set(first, get(second))
        set(second, it)
    }
}
