package xyz.mazuninky.dsa.structure.base

data class ListNode<T>(var value: T, var next: ListNode<T>? = null)

inline fun <T> ListNode<T>?.forEach(action: (item: T) -> Unit) {
    if (this == null)
        return

    var currentNode = this
    while (currentNode != null) {
        action(currentNode.value)
        currentNode = currentNode.next
    }
}

inline fun <T> ListNode<T>?.iterateNodeWithIndex(action: (node: ListNode<T>, nodeIndex: Int) -> Boolean) {
    if (this == null)
        return

    var currentNode = this
    var index = 0
    while (currentNode != null) {
        val needNext = action(currentNode, index)
        if (!needNext)
            return

        index++
        currentNode = currentNode.next
    }
}
