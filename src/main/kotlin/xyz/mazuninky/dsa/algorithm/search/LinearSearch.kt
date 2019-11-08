package xyz.mazuninky.dsa.algorithm.search

/**
 * Linear search
 * O(n)
 */
fun <T> Iterable<T>.linearSearch(element: T): Boolean {
    val iterator = this.iterator()
    while(iterator.hasNext()) {
        if(iterator.next() == element)
            return true
    }
    return false
}
