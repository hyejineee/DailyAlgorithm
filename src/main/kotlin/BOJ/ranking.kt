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
        val expectedRanks = (1..n).map {
            readLine().toInt()
        }

        val sorted = expectedRanks.sorted()
        var total:Long = 0

        for(i in 1..n){
            total += abs(i - sorted[i-1])
        }

        println(total)
    }
}

