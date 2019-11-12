package xyz.mazuninky.dsa.structure

import xyz.mazuninky.dsa.base.DSAMutableStack
import xyz.mazuninky.dsa.base.removeFirst
import xyz.mazuninky.dsa.structure.base.ListNode
import xyz.mazuninky.dsa.structure.base.forEach

class DSALinkedStack<T : Any> : DSAMutableStack<T> {
    private val linkedList = DSAMutableLinkedList<T>()

    override val size: Int
        get() {
            return linkedList.size
        }

    override fun pop(): T {
        return linkedList.removeFirst()
    }

    override fun peek(): T {
        return linkedList.first()
    }

    override fun push(item: T) {
        linkedList.add(item)
    }
}
