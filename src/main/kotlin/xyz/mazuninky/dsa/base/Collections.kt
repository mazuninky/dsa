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
}

interface DSAMutableStack<T> : DSAStack<T> {
    fun push(item: T)
}
