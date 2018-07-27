package xyz.zerotwoone.structure.map

import xyz.zerotwoone.structure.tree.BinarySearchTree

class HashBSTMap<K : Comparable<K>, V>(hashRange: Int, private val keyHashFunc: (K) -> Int) /*: AbstractMutableMap<K, V>()*/ {
    //operator fun Array<BinarySearchTree<K, V>?>.get(key: K): BinarySearchTree<K, V>? = get(keyHashFunc(key))

    private val hashTable = Array<BinarySearchTree<K, V>?>(hashRange) { null }

    fun set(key: K, value: V) {
        val keyHash = keyHashFunc(key)
        if (hashTable[keyHash] == null) {
            hashTable[keyHash] = BinarySearchTree()
        }
        hashTable[keyHash]?.insert(key, value)
    }

    fun get(key: K): V? = hashTable[keyHashFunc(key)]?.find(key)
}
