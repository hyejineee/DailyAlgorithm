package BOJ.y2022.m03.w5


import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    with(BufferedReader(InputStreamReader(System.`in`))) {
        val tc = readLine().toInt()

        for (t in 0 until tc){
            val n = readLine().toInt()

            if(n == 0) {
                println("1 0")
                continue
            }

            if(n ==1){
                println("0 1")
                continue
            }

            val dp = Array(n + 1) { IntArray(2) { 0 } }

            dp[0] = intArrayOf(1, 0)
            dp[1] = intArrayOf(0, 1)

            for (i in 2..n) {
                val count0 = dp[i - 1][0] + dp[i - 2][0]
                val count1 = dp[i - 1][1] + dp[i - 2][1]
                dp[i] = intArrayOf(count0, count1)
            }

            println("${dp[n][0]} ${dp[n][1]}")
        }
    }
}