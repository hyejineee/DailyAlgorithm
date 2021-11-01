package BOJ

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*

fun main() {
    with(BufferedReader(InputStreamReader(System.`in`))) {

        val tc = readLine().toInt()
        (1..tc).forEach {
            val (n, d, c) = readLine().split(" ").map { it.toInt() }
            val g = mutableMapOf<Int, MutableList<List<Int>>>()
            val distances = mutableMapOf<Int, Int>()

            (1..n).forEach {
                g[it] = mutableListOf()
                distances[it] = Float.POSITIVE_INFINITY.toInt()
            }

            (1..d).forEach {
                val (a,b,s) = readLine().split(" ").map { it.toInt() }
                g[b]?.add(listOf(a,s))
            }

            distances[c] = 0
            dijkstra(c, g, distances)

            val count = distances.count{ it.value< Float.POSITIVE_INFINITY.toInt() }
            val time = distances.filter { it.value<Float.POSITIVE_INFINITY.toInt() }.maxOfOrNull { it.value }

            println("$count $time")

        }
    }
}

private fun dijkstra(startNode:Int, g:Map<Int, List<List<Int>>>, distances:MutableMap<Int, Int>){
    val needVisit = PriorityQueue<List<Int>>(compareBy { it.last() })
    needVisit.add(listOf(startNode, 0))

    while (needVisit.isNotEmpty()){
        val (currentNode, currentDistance) = needVisit.poll()

        g[currentNode]?.forEach { (n,v) ->
            val distance = v + currentDistance

            if(distance < (distances[n]?:-1) ){
                distances[n] = distance
                needVisit.add(listOf(n, distance))
            }
        }
    }
}

