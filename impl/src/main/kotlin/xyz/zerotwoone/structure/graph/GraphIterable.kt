package xyz.zerotwoone.structure.graph

interface GraphIterable<T> {
    fun iterator(fromNode: Int): GraphIterator<T>
}
