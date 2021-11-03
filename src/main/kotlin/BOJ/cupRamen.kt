package BOJ

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*
import kotlin.math.abs


fun main() {

    with(BufferedReader(InputStreamReader(System.`in`))) {
        val n = readLine().toInt()

        val problems = (1..n).map { index ->
            val (deadLine, cupRamen) = readLine().split(" ").map { it.toInt() }
            Pair(deadLine, cupRamen)
        }.sortedWith(compareBy { it.first })

        val minHeap = PriorityQueue<Int>()

        for ((deadLine, cupRamen) in problems){
            minHeap.add(cupRamen)

            if(deadLine < minHeap.size){
                minHeap.poll()
            }
        }

        println(minHeap.sum())

    }
}