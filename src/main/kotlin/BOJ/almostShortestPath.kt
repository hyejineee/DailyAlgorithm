package BOJ


import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*

// https://www.acmicpc.net/problem/2798


fun main() {

    with(BufferedReader(InputStreamReader(System.`in`))) {
        val bw = BufferedWriter(OutputStreamWriter(System.out))

        while (true){
            val (n, m) = readLine().split(" ").map { it.toInt() }

            if(n ==0) break

            val (s, d) = readLine().split(" ").map { it.toInt() }

            val g = mutableMapOf<Int, MutableList<List<Int>>>()
            val inG = mutableMapOf<Int, MutableList<List<Int>>>()
            val distances = mutableMapOf<Int, Int>()
            val dropped = MutableList(n){
                MutableList(n){false}
            }


            (0 until n).forEach {
                g[it] = mutableListOf()
                inG[it] = mutableListOf()
                distances[it] = Float.POSITIVE_INFINITY.toInt()
            }

            (0 until m).forEach {
                val (u, v, p) = readLine().split(" ").map { it.toInt() }
                g[u]?.add(listOf(v, p))
                inG[v]?.add(listOf(u, p))
            }

            distances[s] = 0
            dijkstra(s, g, distances, dropped)

            trackingNode(s, d, distances, inG, dropped)
            distances.forEach {
                distances[it.key] = Float.POSITIVE_INFINITY.toInt()
            }

            dijkstra(s,g,distances, dropped)
            println(if(distances[d]?.compareTo(Float.POSITIVE_INFINITY.toInt())==-1) distances[d] else -1)
        }
    }
}

fun dijkstra(startNode: Int, g: MutableMap<Int, MutableList<List<Int>>>, distances: MutableMap<Int, Int>, dropped:List<List<Boolean>>) {
    val needVisit = PriorityQueue<List<Int>>(compareBy { it.last() })
    needVisit.add(listOf(startNode, 0))

    while (needVisit.isNotEmpty()) {
        val (currentNode, currentDistance) = needVisit.poll()

        if((distances[currentNode]?:-1) < currentDistance) continue

        g[currentNode]?.forEach { (n, v) ->
            val distance = v + currentDistance

            if (distance < (distances[n] ?: -1) && (dropped[currentNode][n].not())) {
                distances[n] = distance
                needVisit.add(listOf(n, distance))
            }
        }
    }
}

private fun trackingNode(
    s:Int,
    startNode: Int,
    distances: MutableMap<Int, Int>,
    inG: MutableMap<Int, MutableList<List<Int>>>,
    dropped: MutableList<MutableList<Boolean>>
) {
    val needVisit = Stack<List<Int>>()
    val visited = MutableList(inG.size){false}

    needVisit.add(listOf(startNode, distances[startNode] ?: -1))

    while (needVisit.isNotEmpty()) {
        val (currentNode, shortestDistance) = needVisit.pop()

        if(visited[currentNode]) continue
        visited[currentNode] = true

        inG[currentNode]?.forEach { (n, v) ->
            if (v + (distances[n] ?: 0) == shortestDistance) {
                needVisit.add(listOf(n, distances[n]?:0))
                dropped[n][currentNode] = true

            }
        }
    }
}


