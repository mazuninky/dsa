package xyz.mazuninky.dsa.structure

import xyz.mazuninky.dsa.base.DSAStack
import xyz.mazuninky.dsa.base.removeFirst

class DSALinkedStack<T : Any> : DSAStack<T> {
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
