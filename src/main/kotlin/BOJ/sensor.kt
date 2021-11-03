package BOJ

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter


fun main() {

    with(BufferedReader(InputStreamReader(System.`in`))) {
        val n = readLine().toInt()
        val k = readLine().toInt()

        if(k >=n) {
            println(0)
            return
        }

        val sensors = readLine().split(" ").map { it.toInt() }

        val sortedSensor = sensors.sorted()
        val distances = (1 until n).map {
            sortedSensor[it] - sortedSensor[it-1]
        }

        val sortedDistances = distances.sortedDescending().toMutableList()

        for( i in 0 until  k-1){
            sortedDistances[i] = 0
        }

        println(sortedDistances.sum())

    }
}