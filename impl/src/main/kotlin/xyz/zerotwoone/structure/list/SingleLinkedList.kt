@file:Suppress("NOTHING_TO_INLINE")

package xyz.zerotwoone.structure.list

class SingleLinkedList<T> : MutableList<T> {
    private data class LinkNode<T>(var value: T, var next: LinkNode<T>? = null)

    private inline fun LinkNode<T>?.addToRoot(value: T): LinkNode<T> {
        if (this == null) {
            return LinkNode(value).also {
                rootNode = it
            }
        }
        return this.addToEnd(value)
    }

    private inline fun LinkNode<T>.addToEnd(value: T): LinkNode<T> {
        var node = this
        while (node.next != null)
            node = node.next!!
        return LinkNode(value).also {
            node.next = it
        }
    }

    private var rootNode: LinkNode<T>? = null

    private var count = 0
    override val size: Int = count

    override fun add(element: T): Boolean {
        rootNode.addToRoot(element)
        return true
    }

    override fun add(index: Int, element: T) {
        TODO("not implemented")
    }

    override fun addAll(index: Int, elements: Collection<T>): Boolean {
        TODO("not implemented")
    }

    override fun addAll(elements: Collection<T>): Boolean {
        TODO("not implemented")
    }

    override fun clear() {
        rootNode = null
    }

    override fun contains(element: T): Boolean {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun containsAll(elements: Collection<T>): Boolean {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun indexOf(element: T): Int {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun isEmpty(): Boolean = count == 0

    override fun iterator(): MutableIterator<T> = object : MutableIterator<T> {
        private var nextNode: LinkNode<T>? = rootNode

        override fun hasNext(): Boolean = nextNode != null

        override fun next(): T {
            val value = nextNode!!.value
            nextNode = nextNode!!.next
            return value
        }

        override fun remove() {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }
    }

    override fun lastIndexOf(element: T): Int {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun listIterator(): MutableListIterator<T> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun listIterator(index: Int): MutableListIterator<T> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun remove(element: T): Boolean {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun removeAll(elements: Collection<T>): Boolean {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun removeAt(index: Int): T {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun retainAll(elements: Collection<T>): Boolean {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    private inline fun getNodeByIndex(index: Int): LinkNode<T>? {
        var node: LinkNode<T>? = rootNode
        for (i in 0 until index)
            node = node?.next ?: return null
        return node
    }

    override fun get(index: Int): T {
        return getNodeByIndex(index)?.value ?: throw IndexOutOfBoundsException()
    }

    override fun set(index: Int, element: T): T {
        val node = getNodeByIndex(index) ?: throw IndexOutOfBoundsException()
        node.value = element
        return element
    }

    override fun subList(fromIndex: Int, toIndex: Int): MutableList<T> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}