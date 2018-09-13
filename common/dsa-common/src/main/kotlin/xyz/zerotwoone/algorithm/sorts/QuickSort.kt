package xyz.zerotwoone.algorithm.sorts


fun <T : Comparable<T>> Array<T>.quickSort(start: Int = 0, end: Int = size - 1) {
    if (start > end)
        return
    var i = start
    var j = end
    var pivot = i - (i - j) / 2
    while (i < j) {
        while (i < pivot && get(i) <= get(pivot))
            i++
        while (j > pivot && get(pivot) <= get(j))
            j--

        if (i < j) {
            swap(i, j)
            if (i == pivot)
                pivot = j
            else if (j == pivot)
                pivot = i
        }
        quickSort(start, pivot)
        quickSort(pivot + 1, end)
    }
}

inline fun <T : Comparable<T>> Array<T>.quickSortedArray(): Array<T> =
    copyOf().apply { quickSort() }