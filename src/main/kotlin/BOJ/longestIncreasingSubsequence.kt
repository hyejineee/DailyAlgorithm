package BOJ

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import kotlin.math.max

fun main() {
    with(BufferedReader(InputStreamReader(System.`in`))) {
        val n = readLine().toInt()
        val arr = listOf(listOf(0, 0)) + readLine().split(" ").mapIndexed { index, s -> listOf(index + 1, s.toInt()) }
        val dp = MutableList(n + 1) {
            Pair( 0, mutableListOf(0))
        }

        for (i in 1..n) {
            val (index, _) = arr.subList(0, i).filter { it[1] < arr[i][1] }.maxByOrNull { dp[it[0]].first } ?: listOf()
            val (len, array) = dp[index]
            dp[i] = Pair(len+1, array.toMutableList().apply { add(arr[i][1]) } )
        }

        val max = dp.maxByOrNull { it.first }
        println(max?.first)
        println(max?.second?.apply { removeFirst() }?.joinToString(" "))
    }
}





