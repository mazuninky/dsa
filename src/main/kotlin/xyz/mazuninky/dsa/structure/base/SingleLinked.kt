package xyz.mazuninky.dsa.structure.base

import xyz.mazuninky.dsa.base.DSAList
import xyz.mazuninky.dsa.base.DSAMutableList

class DSALinkedListIterator<T>(root: ListNode<T>?) : Iterator<T> {
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

class DSALinkedListMutableIterator<T : Any>(root: ListNode<T>?, private val list: AbstractMutableLinkedList<T>) : MutableIterator<T> {
    private var lastNode = root
    private var currentNode = root

    override fun hasNext(): Boolean {
        return currentNode != null
    }

    override fun next(): T {
        val nextNode = checkNotNull(currentNode)

        currentNode = nextNode.next

        return nextNode.value
    }

    override fun remove() {
        val last = requireNotNull(lastNode)
        val current = requireNotNull(currentNode)

        if (last === current) {
            list.clear()
            lastNode = null
            currentNode = null
            return
        }

        val next = current.next
        last.next = next
        currentNode = next
    }
}

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

abstract class AbstractLinkedList<T : Any> : DSAList<T> {
    protected var root: ListNode<T>? = null

    override val size: Int
        get() {
            var size = 0
            root.forEach { size++ }
            return size
        }

    override fun get(index: Int): T {
        check(index >= 0) { ArrayIndexOutOfBoundsException() }

        var foundItem: T? = null
        root.iterateNodeWithIndex { node, nodeIndex ->
            if (nodeIndex != index) {
                return@iterateNodeWithIndex true
            }

            foundItem = node.value
            false
        }

        return checkNotNull(foundItem) {
            ArrayIndexOutOfBoundsException()
        }

    }

    override fun iterator(): Iterator<T> {
        return DSALinkedListIterator(root)
    }
}

abstract class AbstractMutableLinkedList<T : Any> : AbstractLinkedList<T>(), DSAMutableList<T> {
    protected var last: ListNode<T>? = null

    override fun add(item: T) {
        val node = ListNode(item)
        val rootNode = root
        if (rootNode == null) {
            root = node
            last = node
        } else {
            val lastNode = checkNotNull(last)
            lastNode.next = node
            last = node
        }
    }

    override fun set(index: Int, item: T) {
        check(index >= 0) { ArrayIndexOutOfBoundsException() }

        var changed = false
        root.iterateNodeWithIndex { node, itemIndex ->
            if (itemIndex != index) {
                return@iterateNodeWithIndex true
            }

            node.value = item
            changed = true
            false
        }

        return check(changed) {
            ArrayIndexOutOfBoundsException()
        }
    }

    fun clear() {
        root = null
        last = null
    }

    override fun iterator(): MutableIterator<T> {
        return DSALinkedListMutableIterator(root, this)
    }
}
