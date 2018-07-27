package xyz.zerotwoone.algorithm.sorts

fun <T : Comparable<T>> Array<T>.bubbleSort() {
    var changed: Boolean
    for (j in 0 until size) {
        changed = false
        for (i in 0 until size - j - 1) {
            if (get(i).compareTo(get(i + 1)) == 1) {
                swap(i, i + 1)
                changed = true
            }
        }
        if (!changed)
            return
    }
}

fun <T : Comparable<T>> Array<T>.bubbleSortedArray(): Array<T> {
    return clone().apply {
        bubbleSort()
    }
}