@file:Suppress("NOTHING_TO_INLINE")

package xyz.zerotwoone.structure.list

//TODO("Need to rewrite iterators")
class SingleLinkedList<V> : AbstractMutableList<V>() {
    private data class LinkNode<V>(var value: V, var next: LinkNode<V>? = null)

    private var rootNode: LinkNode<V>? = null

    override val size: Int by lazy {
        var node: LinkNode<V>? = rootNode
        var counter = 0
        while (node != null) {
            counter++
            node = node.next
        }
        counter
    }

    private inline fun getNodeBeforeIndex(index: Int): LinkNode<V>? {
        var node: LinkNode<V>? = rootNode
        for (i in 0 until index - 1)
            node = node?.next ?: return null
        return node
    }

    override fun add(index: Int, element: V) {
        if (index == 0) {
            rootNode = LinkNode(element)
        } else {
            val beforeNode = getNodeBeforeIndex(index) ?: throw IndexOutOfBoundsException()
            val oldNode = beforeNode.next ?: throw IndexOutOfBoundsException()
            LinkNode(element, oldNode).also {
                beforeNode.next = it
            }
        }
    }

    private inline fun getNodeByIndex(index: Int): LinkNode<V>? {
        var node: LinkNode<V>? = rootNode
        for (i in 0 until index)
            node = node?.next ?: return null
        return node
    }

    override fun get(index: Int): V {
        return getNodeByIndex(index)?.value ?: throw IndexOutOfBoundsException()
    }

    override fun removeAt(index: Int): V {
        if (index == 0) {
            val value = rootNode?.value ?: throw IndexOutOfBoundsException()
            rootNode = null
            return value
        }

        val beforeNode = getNodeBeforeIndex(index) ?: throw IndexOutOfBoundsException()
        val node = beforeNode.next ?: throw IndexOutOfBoundsException()
        beforeNode.next = node.next
        return node.value
    }

    override fun set(index: Int, element: V): V {
        val node = getNodeByIndex(index) ?: throw IndexOutOfBoundsException()
        node.value = element
        return element
    }


    /*
      private inline fun LinkNode<V>?.addToRoot(value: V): LinkNode<V> {
        if (this == null) {
            count++
            return LinkNode(value).also {
                rootNode = it
            }
        }
        return this.addToEnd(value)
    }

    private inline fun LinkNode<V>.addToEnd(value: V): LinkNode<V> {
        var node = this
        while (node.next != null)
            node = node.next!!
        count++
        return LinkNode(value).also {
            node.next = it
        }
    }

    override fun add(element: T): Boolean {
        rootNode.addToRoot(element)
        return true
    }

    override fun clear() {
        rootNode = null
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
            TODO("not implemented")
        }
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
    }*/
}