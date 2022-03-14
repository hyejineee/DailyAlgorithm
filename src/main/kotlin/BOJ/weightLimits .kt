package BOJ

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*
import kotlin.math.max
import kotlin.math.min


fun main() {

    with(BufferedReader(InputStreamReader(System.`in`))) {
        val bw = BufferedWriter(OutputStreamWriter(System.out))

        val (n, m) = readLine().split(" ").map { it.toInt() }
        val g = mutableMapOf<Int, MutableList<List<Int>>>()

        var start = 1000000000
        var end = 1

        (0 until m).map {
            val (node1, node2, w) = readLine().split(" ").map { it.toInt() }
            g[node1]?.add(listOf(node2, w)) ?: kotlin.run { g[node1] = mutableListOf(listOf(node2, w)) }
            g[node2]?.add(listOf(node1, w)) ?: kotlin.run { g[node2] = mutableListOf(listOf(node1, w)) }
            start = min(start, w)
            end = max(end, w)
        }

        val (startNode, endNode) = readLine().split(" ").map { it.toInt() }
        var result = 0

        while (start <= end) {
            val mid = (start + end) / 2
            if (bfs(mid, g, startNode, endNode, n)) {
                result = mid
                start = mid + 1
            } else {
                end = mid - 1
            }
        }

        bw.write("$result")


        bw.flush()
        bw.close()
    }
}

fun bfs(limitW: Int, g: MutableMap<Int, MutableList<List<Int>>>, startNode: Int, endNode: Int, n: Int): Boolean {

    val visited = MutableList(n + 1) { false }
    val needVisited = LinkedList<Int>()
    needVisited.push(startNode)

    while (needVisited.isNotEmpty()) {
        val pop = needVisited.pop()

        g[pop]?.forEach { (n2, w) ->
            if (!visited[n2] && w >= limitW) {
                visited[n2] = true
                needVisited.add(n2)
            }
        }
    }

    return visited[endNode]
}