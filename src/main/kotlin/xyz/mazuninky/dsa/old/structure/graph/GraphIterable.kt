package xyz.mazuninky.dsa.old.structure.graph

interface GraphIterable<T> {
    fun iterator(fromNode: Int): GraphIterator<T>
}
