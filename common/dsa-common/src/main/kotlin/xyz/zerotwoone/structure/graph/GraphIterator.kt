package xyz.zerotwoone.structure.graph

interface GraphIterator<T> {
    fun nextNodes(): IntArray
    fun next(index: Int): T
}