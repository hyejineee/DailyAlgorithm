package BOJ

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import kotlin.math.max

fun main() {
    with(BufferedReader(InputStreamReader(System.`in`))) {
        val n = readLine().toInt()
        val arr = listOf(listOf(0,0)) + readLine().split(" ").mapIndexed { index, s ->  listOf(index+1,s.toInt()) }
        val dp = IntArray(n+1){0}

        for(i in 1..n){
            val (maxIndex, maxValue) = arr.subList(0,i).filter { it[1] < arr[i][1] }.maxByOrNull { dp[it[0]] }?: listOf()
            dp[i] = arr[i][1] + dp[maxIndex]
        }

        println(dp.maxOrNull()?:-1)
    }
}





