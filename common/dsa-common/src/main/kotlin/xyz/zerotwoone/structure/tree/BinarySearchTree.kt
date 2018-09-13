package xyz.zerotwoone.structure.tree

class BinarySearchTree<K : Comparable<K>, V> : Tree<K, V>, BinaryTreeIterable<K, V> {
    private data class BinarySearchTreeNode<K : Comparable<K>, V>(val key: K, var value: V,
                                                                  var left: BinarySearchTreeNode<K, V>? = null,
                                                                  var right: BinarySearchTreeNode<K, V>? = null) {
        fun insert(key: K, value: V) {
            when {
                this.key < key -> if (right == null)
                    right = BinarySearchTreeNode(key, value)
                else
                    right?.insert(key, value)
                this.key == key -> this.value = value
                this.key > key -> if (left == null)
                    left = BinarySearchTreeNode(key, value)
                else
                    left?.insert(key, value)
            }
        }

        fun find(key: K): V? = when {
            this.key == key -> value
            this.key > key -> left?.find(key)
            this.key < key -> right?.find(key)
            else -> null
        }
    }

    private inline fun <K : Comparable<K>, V> BinarySearchTreeNode<K, V>?.findIfNullable(key: K): V? {
        if (this == null)
            return null
        return find(key)
    }

    private var root: BinarySearchTreeNode<K, V>? = null

    fun isEmpty(): Boolean = root == null

    override fun insert(key: K, value: V) {
        if (root == null)
            root = BinarySearchTreeNode(key, value)
        else
            root?.insert(key, value)
    }

    override fun find(key: K): V? = root.findIfNullable(key)

    override fun iterator(): BinaryTreeIterator<K, V> = object : BinaryTreeIterator<K, V> {
        var next = root

        override fun hasNextLeft(): Boolean = next?.left == null

        override fun hasNextRight(): Boolean = next?.right == null

        override fun nextLeft(): Pair<K, V> {
            next = next?.left
            return Pair(key(), value())
        }

        override fun nextRight(): Pair<K, V> {
            next = next?.right
            return Pair(key(), value())
        }

        override fun key(): K = next!!.key

        override fun value(): V = next!!.value

    }
}
