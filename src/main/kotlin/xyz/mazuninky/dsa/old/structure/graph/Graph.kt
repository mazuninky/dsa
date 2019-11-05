package xyz.mazuninky.dsa.old.structure.graph

interface Graph<T> {
    val size: Int
    operator fun get(fromNode: Int, targetNode: Int): T
}

