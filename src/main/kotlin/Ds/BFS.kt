package Ds

import java.util.*

fun main() {
    val graph = mapOf(
        'A' to mapOf('B' to 8, 'C' to 1, 'D' to 2),
        'B' to mapOf(),
        'C' to mapOf('B' to 5, 'D' to 2),
        'D' to mapOf('E' to 3, 'F' to 5),
        'E' to mapOf('F' to 1),
        'F' to mapOf('A' to 5),
    )

    val queue = PriorityQueue<Pair<Char, Int>>(compareBy { it.second }).apply {
        add(Pair('A', 0))
    }


    val distanceArray = mutableMapOf(
        'A' to 0,
        'B' to Int.MAX_VALUE,
        'C' to Int.MAX_VALUE,
        'D' to Int.MAX_VALUE,
        'E' to Int.MAX_VALUE,
        'F' to Int.MAX_VALUE,
    )

    println(dijkstra(distanceArray, queue, graph))


}

fun dijkstra(
    distanceArray: MutableMap<Char, Int>,
    priorityQueue: PriorityQueue<Pair<Char, Int>>,
    graph: Map<Char, Map<Char, Int>>
): MutableMap<Char, Int> {

    if (priorityQueue.isEmpty()) {
        return distanceArray
    }

    val (currentNode, currentDistance) = priorityQueue.poll()

    graph[currentNode]?.forEach {
        val distance = currentDistance + it.value

        if ((distanceArray[it.key] ?: 0) > distance) {
            distanceArray[it.key] = distance
            priorityQueue.add(Pair(it.key, distance))
        }

    }
    return dijkstra(distanceArray, priorityQueue, graph)
}


fun bfs(needVisit: LinkedList<Char>, visited: LinkedList<Char>, graph: Map<Char, CharArray>) {
    
    if (needVisit.isEmpty()) {
        return
    }

    val pop = needVisit.pop()

    if (pop !in visited) {
        visited.add(pop)

        println(pop)

        graph[pop]?.forEach {
            needVisit.add(it)
        }
    }

    return bfs(needVisit, visited, graph)
}

fun dfs(needVisit: Stack<Char>, visited: LinkedList<Char>, graph: Map<Char, CharArray>) {

    if (needVisit.isEmpty()) {
        return
    }

    val pop = needVisit.pop()

    if (pop !in visited) {
        visited.add(pop)

        println(pop)

        graph[pop]?.forEach {
            needVisit.push(it)
        }
    }

    return dfs(needVisit, visited, graph)
}

