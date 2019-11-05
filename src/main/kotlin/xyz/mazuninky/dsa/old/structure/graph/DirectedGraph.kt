package xyz.mazuninky.dsa.old.structure.graph

import java.util.*

class DirectedGraph<T>(override val size: Int) : MutableGraph<T> {
    private val graphNodes = ArrayList<T>(size * size)

    override fun set(fromNode: Int, targetNode: Int, value: T) {
        graphNodes[fromNode * size + targetNode] = value
    }

    override fun get(fromNode: Int, targetNode: Int): T =
            graphNodes[fromNode * size + targetNode]
}
