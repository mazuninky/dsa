package xyz.mazuninky.dsa.old.structure.tree

interface BinaryTreeIterable<K : Comparable<K>, V> {
    fun iterator(): BinaryTreeIterator<K, V>
}
