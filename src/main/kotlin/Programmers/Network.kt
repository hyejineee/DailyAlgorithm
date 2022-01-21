package Programmers

fun network(n: Int, computers: Array<IntArray>): Int {
    val vertices = IntArray(n) { it }
    val edges = mutableListOf<Pair<Int, Int>>()

    computers.forEachIndexed { i, v ->
        for (j in i + 1 until v.size) {
            if (computers[i][j] == 1) {
                edges.add(Pair(i, j))
            }
        }
    }

    val parents = mutableMapOf<Int, Int>()
    val ranks = mutableMapOf<Int, Int>()

    vertices.forEach {
        parents[it] = it
        ranks[it] = 0
    }

    for (i in vertices.indices) {
        val v = vertices[i]

        if (v != parents[v]) continue

        edges.forEach {
            val (n1, n2) = it
            if (find(n1, parents) != find(n2, parents)) {
                union(n1, n2, parents, ranks)
            }
        }
    }

    return parents.values.groupBy { it }.size
}

private fun find(node: Int, parents: MutableMap<Int, Int>): Int {
    parents[node]?.let {
        if (node != it) {
            parents[node] = find(it, parents)
        }
    }

    return parents[node] ?: -1
}

private fun union(node1: Int, node2: Int, parents: MutableMap<Int, Int>, ranks: MutableMap<Int, Int>) {

    val root1 = parents[node1] ?: -1
    val root2 = parents[node2] ?: -1

    if (ranks[root1]!! < ranks[root2]!!) {
        parents[root1] = root2
    } else if (ranks[root1]!! > ranks[root2]!!) {
        parents[root2] = root1
    } else {
        ranks[root2] = ranks[root2]!!.plus(1)
        parents[root1] = root2
    }
}