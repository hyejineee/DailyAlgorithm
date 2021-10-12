package Problems

import java.util.*

fun friendNetwork(f: Int, friendship: Array<Array<String>>): IntArray {

    val numberOfFriends = mutableListOf<Int>()
    val graph: HashMap<String, MutableList<String>> = HashMap()

    friendship.forEach {

        graph[it[0]] =
            graph[it[0]]?.apply {
                add(it[1])
            } ?: mutableListOf(it[1])

        graph[it[1]] =
            graph[it[1]]?.apply {
                add(it[0])
            } ?: mutableListOf(it[0])

        numberOfFriends.add(BFS(graph, it[0]))

    }
    return numberOfFriends.toIntArray()
}

fun BFS(graph: HashMap<String, MutableList<String>>, find: String): Int {

    val needVisitQueue = LinkedList<String>()
    val visited = LinkedList<String>()

    needVisitQueue.add(find)

    while (needVisitQueue.isNotEmpty()) {
        val pop = needVisitQueue.poll()

        if (pop !in visited) {
            visited.add(pop)
            graph[pop]?.forEach {
                needVisitQueue.add(it)
            }
        }

    }

    return visited.count()
}

