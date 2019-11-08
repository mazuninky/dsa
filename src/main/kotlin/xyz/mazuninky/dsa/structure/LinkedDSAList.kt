package xyz.mazuninky.dsa.structure

import xyz.mazuninky.dsa.base.DSAList

data class ListNode<T>(val value: T, val next: ListNode<T>? = null)

inline fun <T> ListNode<T>?.forEach(action: (T) -> Unit) {
    if (this == null)
        return

    var currentNode = this
    while (currentNode != null) {
        action(currentNode.value)
        currentNode = currentNode.next
    }
}

inline fun <T> ListNode<T>?.iterateWithIndex(action: (T, Int) -> Boolean) {
    if (this == null)
        return

    var currentNode = this
    var index = 0
    while (currentNode != null) {
        val needNext = action(currentNode.value, index)
        if (!needNext)
            return

        index++
        currentNode = currentNode.next
    }
}

class LinkedDSAList<T : Any> : DSAList<T> {
    class LinkedDSAListIterator<T>(root: ListNode<T>?) : Iterator<T> {
        private var currentNode = root

        override fun hasNext(): Boolean {
            return currentNode != null
        }

        override fun next(): T {
            val nextNode = checkNotNull(currentNode)

            currentNode = nextNode.next

            return nextNode.value
        }
    }

    private var root: ListNode<T>? = null

    override val size: Int
        get() {
            var size = 0
            root.forEach { size++ }
            return size
        }

    override fun get(index: Int): T {
        check(index >= 0) { ArrayIndexOutOfBoundsException() }

        var foundItem: T? = null
        root.iterateWithIndex { item, itemIndex ->
            if (itemIndex != index) {
                return@iterateWithIndex true
            }

            foundItem = item
            false
        }

        return checkNotNull(foundItem) {
            ArrayIndexOutOfBoundsException()
        }

    }

    override fun iterator(): Iterator<T> {
        return LinkedDSAListIterator(root)
    }
}
