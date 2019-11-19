package xyz.mazuninky.dsa.structure

import xyz.mazuninky.dsa.base.DSAQueue

class Queue<T : Any> : DSAQueue<T> {
    private val linkedList = DSAMutableLinkedList<T>()

    override val size: Int
        get() = linkedList.size

    override fun dequeue(): T {
        TODO()
    }

    override fun enqueue(item: T) {
        TODO()
    }
}
