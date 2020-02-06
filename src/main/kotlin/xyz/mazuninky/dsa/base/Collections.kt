package xyz.mazuninky.dsa.base

import java.util.*

interface DSACollection<T> : Iterable<T> {
    val size: Int
}

interface DSAMutableCollection<T> : DSACollection<T>, MutableIterable<T> {
    fun add(item: T)
}

interface DSAList<T> : DSACollection<T> {
    operator fun get(index: Int): T
}

interface DSAMutableList<T> : DSAList<T>, DSAMutableCollection<T> {
    operator fun set(index: Int, item: T)
    fun remove(index: Int): T
}

interface DSAStack<T> {
    val size: Int
    fun pop(): T
    fun peek(): T
    fun push(item: T)
}

interface DSAQueue<T> {
    val size: Int
    fun dequeue(): T
    fun enqueue(item: T)
}

interface DSAMap<K, V> {
    val size: Int
    fun get(key: K): V
}

interface DSAMutableMap<K, V> : DSAMap<K, V> {
    fun add(key: K): V
}
