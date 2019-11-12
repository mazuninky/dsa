package xyz.mazuninky.dsa.structure.base

import xyz.mazuninky.dsa.base.DSAList
import xyz.mazuninky.dsa.base.DSAMutableList

class DSASingleLinkedListIterator<T>(root: ListNode<T>?) : Iterator<T> {
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
        return DSASingleLinkedListIterator(root)
    }
}
