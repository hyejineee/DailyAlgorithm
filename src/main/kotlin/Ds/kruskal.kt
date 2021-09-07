package Ds

fun main() {
    val vertices = listOf('A', 'B', 'C', 'D', 'E', 'F', 'G')
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

    println(kruskal(vertices, edges))

}

fun kruskal(vertices: List<Char>, edges: List<Triple<Int, Char, Char>>): MutableList<Triple<Int, Char, Char>> {
    val parent = mutableMapOf<Char, Char>()
    val rank = mutableMapOf<Char, Int>()

    val mst = mutableListOf<Triple<Int, Char, Char>>()

    vertices.forEach {
        parent[it] = it
        rank[it] = 0
    }

    val sorted = edges.sortedBy { it.first }

    sorted.forEach {
        val (_, node1, node2) = it

        if (find(node1, parent) != find(node2, parent)) {
            union(node1, node2, parent, rank)
            mst.add(it)
        }

    }
    return mst
}

fun find(node: Char, parent: MutableMap<Char, Char>): Char {

    if (parent[node] != node) {
        parent[node] = find(
            parent[node] ?: node,
            parent
        )
    }
    return parent[node] ?: node
}

fun union(node1: Char, node2: Char, parent: MutableMap<Char, Char>, rank: MutableMap<Char, Int>) {
    val root1 = find(node1, parent)
    val root2 = find(node2, parent)

    if (rank[root1]!! > rank[root2]!!) {
        parent[root2] = root1
    } else {
        parent[root1] = root2
    }

    if (rank[root1]!! == rank[root2]!!) {
        rank[root2]?.plus(1)
        parent[root1] = root2
    }
}