package xyz.mazuninky.dsa.old.structure.map

import xyz.mazuninky.dsa.old.structure.tree.BinarySearchTree

class HashBSTMap<K : Comparable<K>, V>(hashRange: Int, private val keyHashFunc: (K) -> Int) {

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
