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
    println(dijkstraWhile(graph))

    val bfsGraph = mapOf(
        'A' to charArrayOf('B', 'C'),
        'B' to charArrayOf('A', 'D'),
        'C' to charArrayOf('A', 'G', 'H', 'I'),
        'D' to charArrayOf('B', 'E', 'F'),
        'E' to charArrayOf('D'),
        'F' to charArrayOf('D'),
        'G' to charArrayOf('C'),
        'H' to charArrayOf('C'),
        'I' to charArrayOf('C', 'J'),
        'J' to charArrayOf('I'),
    )

    println(bfsWhile(bfsGraph))
    println(dfsWhile(bfsGraph))
}

fun dijkstraWhile(graph: Map<Char, Map<Char, Int>>): MutableMap<Char, Int> {

    val distances = graph.map {
        it.key to Float.POSITIVE_INFINITY.toInt()
    }.toMap().toMutableMap()

    val needVisit = TreeSet<Pair<Char, Int>> { o1, o2 ->
        when {
            o1.second < o2.second -> -1
            o1.second > o2.second -> 1
            else -> 0
        }
    }

    distances['A'] = 0
    needVisit.add(Pair('A', 0))

    while (needVisit.isNotEmpty()) {
        val (popNode, popDistance) = needVisit.pollFirst()

        graph[popNode]?.forEach {
            val d = it.value + popDistance
            if (distances[it.key]!! > d) {
                distances[it.key] = d
                needVisit.add(Pair(it.key, d))
            }
        }
    }

    return distances
}

fun bfsWhile(graph: Map<Char, CharArray>): Queue<Char> {

    val visited: Queue<Char> = LinkedList()
    val needVisit: Queue<Char> = LinkedList()

    needVisit.offer('A')

    while (needVisit.isNotEmpty()) {
        val pop = needVisit.poll()

        if (pop !in visited) {
            visited.add(pop)

            graph[pop]?.forEach {
                needVisit.offer(it)
            }
        }
    }
    return visited
}

fun dfsWhile(graph: Map<Char, CharArray>): Queue<Char> {

    val visited: Queue<Char> = LinkedList()
    val needVisit: Stack<Char> = Stack()

    needVisit.push('A')

    while (needVisit.isNotEmpty()) {
        val pop = needVisit.pop()

        if (pop !in visited) {
            visited.add(pop)

            graph[pop]?.forEach {
                needVisit.push(it)
            }
        }
    }

    return visited
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


tailrec fun bfs(needVisit: LinkedList<Char>, visited: LinkedList<Char>, graph: Map<Char, CharArray>) {

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

