package xyz.zerotwoone.structure.graph

interface Graph<T> {
    val size: Int
    operator fun get(fromNode: Int, targetNode: Int): T
}

