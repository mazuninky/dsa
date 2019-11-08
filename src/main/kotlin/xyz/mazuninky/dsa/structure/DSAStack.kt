package xyz.mazuninky.dsa.structure

import xyz.mazuninky.dsa.base.DSAMutableStack
import xyz.mazuninky.dsa.base.DSAStack
import xyz.mazuninky.dsa.structure.base.AbstractMutableLinkedList
import xyz.mazuninky.dsa.structure.base.ListNode
import xyz.mazuninky.dsa.structure.base.forEach

class DSALinkedStack<T : Any> : DSAMutableStack<T> {
    override val size: Int
        get() {
            var size = 0
            root.forEach { size++ }
            return size
        }

    private var root: ListNode<T>? = null

    override fun pop(): T {
        val lastNode = checkNotNull(root)

        root = lastNode.next

        return lastNode.value
    }

    override fun peek(): T {
        val lastNode = checkNotNull(root)

        return lastNode.value
    }

    override fun push(item: T) {
        val node = ListNode(item)
        if (root == null) {
            root = node
            return
        }

        node.next = root
        root = node
    }
}
