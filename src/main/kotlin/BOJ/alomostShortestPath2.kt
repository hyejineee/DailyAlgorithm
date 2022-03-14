package BOJ

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*

fun main() {
    with(BufferedReader(InputStreamReader(System.`in`))) {
        while (true){
            val (n,m) = readLine().split(" ").map { it.toInt() }

            if(n == 0) break

            val g = mutableMapOf<Int, MutableList<List<Int>>>()
            val distances = mutableMapOf<Int, Int>()
            val dropped = MutableList(n){
                MutableList(n){false}
            }
            val inG = mutableMapOf<Int, MutableList<List<Int>>>()

            (0 until n).forEach{
                g[it] = mutableListOf()
                inG[it] = mutableListOf()
                distances[it] = Float.POSITIVE_INFINITY.toInt()
            }

            val (start, end) = readLine().split(" ").map { it.toInt() }

            (1..m).forEach {
                val(u,v,p) = readLine().split(" ").map { it.toInt() }
                g[u]?.add(listOf(v,p))
                inG[v]?.add(listOf(u,p))
            }

            distances[start] = 0
            dijkstra(start, g, distances, dropped)

            findDropped(end, inG, dropped, distances)

            (0 until n).forEach {
                distances[it] = Float.POSITIVE_INFINITY.toInt()
            }

            dijkstra(start, g, distances, dropped)

            println(if(distances[end]!! < Float.POSITIVE_INFINITY.toInt()) distances[end] else -1)


        }
    }
}

private fun dijkstra(start:Int, g:MutableMap<Int, MutableList<List<Int>>>, distances:MutableMap<Int,Int>, dropped:MutableList<MutableList<Boolean>>){
    val needVisit = LinkedList<List<Int>>()
    needVisit.add(listOf(start, 0))

    while (needVisit.isNotEmpty()){
        val (currentNode, currentDistance) = needVisit.pollFirst()

        if(distances[currentNode]!! < currentDistance) continue

        g[currentNode]?.forEach { (n,v) ->
            val distance = v + currentDistance

            if(distance < (distances[n]?:Float.POSITIVE_INFINITY.toInt()) && !dropped[currentNode][n]){
                distances[n] = distance
                needVisit.add(listOf(n, distance))
            }

        }
    }
}

private fun findDropped(end: Int, inG : Map<Int, List<List<Int>>>, dropped: MutableList<MutableList<Boolean>>, distances: MutableMap<Int, Int>){
    val needVisit = Stack<List<Int>>()
    needVisit.add(listOf(end, distances[end]!!))

    val visited = mutableListOf<Int>()

    while (needVisit.isNotEmpty()){
        val (currentNode, currentP) = needVisit.pop()

        if(currentNode in visited) continue
        visited.add(currentNode)

        inG[currentNode]?.forEach { (n, v) ->
            if( v + (distances[n]!!) == currentP){
                needVisit.add(listOf(n, distances[n]!!))
                dropped[n][currentNode] = true
            }
        }
    }
}

