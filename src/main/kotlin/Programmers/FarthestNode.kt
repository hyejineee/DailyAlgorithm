package Programmers

import java.util.*

fun farthestNode(n: Int, edge: Array<IntArray>): Int {
    val distances = Array(n) {
        if (it == 0) 0 else Int.MAX_VALUE
    }

    val graph = mutableMapOf<Int, MutableList<Int>>()

    edge.forEach {
        val (a, b) = it
        graph[a]?.add(b) ?: run { graph[a] = mutableListOf(b) }
        graph[b]?.add(a) ?: run { graph[b] = mutableListOf(a) }
    }

    calculateDistance(LinkedList<Pair<Int, Int>>().apply { add(Pair(1, 0)) }, distances, graph.toMap())

    val max = distances.max() ?: -1

    return distances.count { it == max }
}

private fun calculateDistance(
    needVisit: LinkedList<Pair<Int, Int>>,
    distances: Array<Int>,
    graph: Map<Int, MutableList<Int>>
) {

    if (needVisit.isEmpty()) {
        return
    }

    val (node, currentDistance) = needVisit.poll()

    graph[node]?.forEach {
        val newDistance = currentDistance + 1

        if (distances[it - 1] > newDistance) {
            distances[it - 1] = newDistance
            needVisit.add(Pair(it, newDistance))
        }
    }

    return calculateDistance(needVisit, distances, graph)
}


