package xyz.mazuninky.dsa.structure.base

import xyz.mazuninky.dsa.base.DSAList
import xyz.mazuninky.dsa.base.DSAMutableList

class DSASingleLinkedListMutableIterator<T : Any>(root: ListNode<T>?,
                                                  private val list: AbstractMutableLinkedList<T>) : MutableIterator<T> {
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

    override fun remove(index: Int): T {
        check(index >= 0)
        check(index < size)

        if (index == 0) {
            val node = checkNotNull(root)
            root = node.next
            return node.value
        }

        val before = checkNotNull(root)
        var removed = false
        var value: T? = null
        root.iterateNodeWithIndex { node, itemIndex ->
            if (itemIndex != index) {
                last = node
                return@iterateNodeWithIndex true
            }

            value = node.value
            before.next = node.next
            removed = true
            false
        }

        check(removed)
        return value as T
    }

    fun clear() {
        root = null
        last = null
    }

    override fun iterator(): MutableIterator<T> {
        return DSASingleLinkedListMutableIterator(root, this)
    }
}
