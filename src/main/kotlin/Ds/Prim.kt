package Ds


fun main() {
    val edges = listOf(
        Triple(7, 'A', 'B'),
        Triple(5, 'A', 'D'),
        Triple(9, 'D', 'B'),
        Triple(8, 'B', 'C'),
        Triple(7, 'B', 'F'),
        Triple(7, 'D', 'F'),
        Triple(5, 'C', 'F'),
        Triple(6, 'D', 'E'),
        Triple(8, 'E', 'F'),
        Triple(11, 'E', 'G'),
        Triple(9, 'G', 'F')
    )


    prim('A', edges)

}

fun prim(startNode: Char, edges: List<Triple<Int, Char, Char>>) {

    // 노드에 인접한 간선 정보를 저장
    val adjacentEdges = mutableMapOf<Char, MutableList<Triple<Int, Char, Char>>>()

    for ((w, n1, n2) in edges) {
        adjacentEdges[n1]?.add(Triple(w, n1, n2)) ?: run { adjacentEdges[n1] = mutableListOf(Triple(w, n1, n2)) }
        adjacentEdges[n2]?.add(Triple(w, n2, n1)) ?: run { adjacentEdges[n2] = mutableListOf(Triple(w, n2, n1)) }
    }

    val connectedNode = mutableListOf(startNode)
    var edgeList = mutableListOf<Triple<Int, Char, Char>>()


    adjacentEdges[startNode]?.forEach {
        edgeList.add(it)
    }

    val mst = mutableListOf<Triple<Int, Char, Char>>()

    while (edgeList.isNotEmpty()) {
        val (w, n1, n2) = edgeList.poll()

        if (n2 !in connectedNode) {
            connectedNode.add(n2)
            mst.add(Triple(w, n1, n2))

            for (edge in adjacentEdges[n2]!!) {
                if (edge.third !in connectedNode) {
                    edgeList.add(edge)
                }
            }
        }

        edgeList.sortBy { it.first }
    }

    println(mst)

}

fun <T> MutableList<T>.poll(): T {
    val value = this.first()
    this.removeFirst()
    return value
}

