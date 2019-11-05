package xyz.mazuninky.dsa.old.structure.graph

interface GraphIterator<T> {
    fun nextNodes(): IntArray
    fun next(index: Int): T
}
