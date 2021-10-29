package BOJ

import Programmers.result
import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*

fun main() {
    with(BufferedReader(InputStreamReader(System.`in`))) {
        val bw = BufferedWriter(OutputStreamWriter(System.out))

        val tc = readLine().toInt()

        (1..tc).forEach {
            val (n, d, c) = readLine().split(" ").map { it.toInt() }
            val g = mutableMapOf<Int, MutableList<Pair<Int, Int>>>()
            val distances = mutableMapOf<Int, Int>()

            (1..n).forEach {
                g[it] = mutableListOf()
                distances[it] = Float.POSITIVE_INFINITY.toInt()
            }

            (1..d).forEach {
                val (a, b, s) = readLine().split(" ").map { it.toInt() }
                g[b]?.add(Pair(a,s))
            }

            distances[c] = 0
            dijkstra(c, g, distances)

            val count = distances.count { it.value < (Float.POSITIVE_INFINITY.toInt()) }
            val time = distances.filter { it.value < Float.POSITIVE_INFINITY.toInt()  }.maxOfOrNull { it.value }


            bw.write("$count $time\n")
        }
        bw.flush()
        bw.close()
    }
}

private fun dijkstra(start:Int, g:MutableMap<Int, MutableList<Pair<Int, Int>>>, distances:MutableMap<Int, Int>){
    val needVisit = LinkedList<Pair<Int, Int>>()
    needVisit.add(Pair(start, 0))

    while (needVisit.isNotEmpty()){
        val (currentNode, currentDistance) = needVisit.pollFirst()

        g[currentNode]?.forEach { (n, v) ->
            val distance = v + currentDistance

            if(distance < (distances[n]?:-1)){
                distances[n] = distance
                needVisit.add(Pair(n, distance))
            }
        }
    }
}