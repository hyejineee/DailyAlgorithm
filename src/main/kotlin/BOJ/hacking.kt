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

        val tc = readLine().toInt()

        (1..tc).forEach {
            val (n,d,c) = readLine().split(" ").map { it.toInt() }

            val g = mutableMapOf<Int, MutableList<List<Int>>>()
            val distances = mutableMapOf<Int, Int>()

            (1..n).forEach {
                g[it] = mutableListOf()
                distances[it] = Int.MAX_VALUE
            }

            (1..d).forEach{
                val (a,b,s) = readLine().split(" ").map { it.toInt() }
                g[b]?.add(listOf(a,s))
            }

            distances[c] = 0
            dijkstra(c, g, distances)

            val count = distances.count { it.value in 0 until Int.MAX_VALUE }
            val time = distances.values.filter { it < Int.MAX_VALUE }.maxOrNull()?:-1

            println("$count $time")

        }

    }
}

private fun dijkstra(startComputer : Int, g:MutableMap<Int, MutableList<List<Int>>>, distances:MutableMap<Int,Int>){

    val needVisit = PriorityQueue<List<Int>>(compareBy{it[1]})
    needVisit.add(listOf(startComputer, 0))


    while (needVisit.isNotEmpty()){
        val (node, distance) = needVisit.poll()

        g[node]?.forEach { (n, v) ->
            val newDistance = v + distance

            if(newDistance < (distances[n]?:0)){
                distances[n] = newDistance
                needVisit.add(listOf(n,newDistance))
            }
        }
    }
}
