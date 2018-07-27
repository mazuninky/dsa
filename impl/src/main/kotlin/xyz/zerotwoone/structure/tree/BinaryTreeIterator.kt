package xyz.zerotwoone.structure.tree

interface BinaryTreeIterator<K : Comparable<K>, V> {
    fun hasNextLeft(): Boolean
    fun hasNextRight(): Boolean
    fun nextLeft(): Pair<K, V>
    fun nextRight(): Pair<K, V>
    fun key(): K
    fun value(): V
}