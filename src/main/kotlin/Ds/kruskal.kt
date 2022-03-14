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
    println(k(vertices, edges))

}


/**
 *  크루스칼 복습하기
 *  - 크루스칼 : 최소신장트리를 찾기 위한 알고리즘
 *  - union- find 알고리즘을 사용한다.
 *  - find할 때 연결되 상위 노드를 한번에 알기위해 path-compression알고리즘을 사용한다.
 *  - union시 union-by-rank를 사용한다.
 *  - 간선 비용이 적은 순으로 탐색
 * */

fun k(vertices: List<Char>, edges: List<Triple<Int, Char, Char>>): MutableList<Triple<Int, Char, Char>> {

    // 연결된 최상위 노드 정보를 저장
    val parent = mutableMapOf<Char, Char>()
    // union시 필요한 rank값을 저장
    val rank = mutableMapOf<Char, Int>()
    // mst를 저장
    val mst = mutableListOf<Triple<Int, Char, Char>>()

    vertices.forEach {
        parent[it] = it
        rank[it] = 0
    }

    val sorted = edges.sortedBy { it.first }

    sorted.forEach {
        val (w, node, linkedNode) = it

        if (find2(node, parent) != find2(linkedNode, parent)) {
            union(node, linkedNode, parent, rank)
            mst.add(it)
        }
    }

    return mst
}


fun find2(node: Char, parents: MutableMap<Char, Char>): Char {
    if (node != parents[node]) {
        parents[node] = find2(parents[node]!!, parents)
    }

    return parents[node]!!
}

fun union2(node1: Char, node2: Char, rank: MutableMap<Char, Int>, parent: MutableMap<Char, Char>) {
    val r1 = parent[node1]!!
    val r2 = parent[node2]!!

    if (rank[r1]!! > rank[r2]!!) {
        parent[r2] = r1
    } else {
        parent[r1] = r2
    }

    if (rank[r1]!! == rank[r2]!!) {
        rank[r1]!!.plus(1)
        parent[r2] = r1
    }
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