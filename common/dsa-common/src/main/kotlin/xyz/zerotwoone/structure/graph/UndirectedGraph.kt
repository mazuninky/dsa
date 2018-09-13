package xyz.zerotwoone.structure.graph

class UndirectedGraph<T>(override val size: Int) : MutableGraph<T> {
    //TODO("Remove node weight dublication")
    private val graphNodes = ArrayList<T>(size * size)

    override fun set(fromNode: Int, targetNode: Int, value: T) {
        graphNodes[fromNode * size + targetNode] = value
        graphNodes[targetNode * size + fromNode] = value
    }

    override fun get(fromNode: Int, targetNode: Int): T =
            graphNodes[fromNode * size + targetNode]
}
