package BOJ.y2022.m03.w5


import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    with(BufferedReader(InputStreamReader(System.`in`))) {
        val tc = readLine().toInt()
        val seed = longArrayOf(0, 1, 1, 1, 2, 2, 3, 4, 5, 7, 9)

        for (t in 0 until tc) {
            val n = readLine().toInt()
            val dp = if (n < 11) seed else LongArray(n + 1) { i ->
                if (i <= 10) seed[i] else 0
            }

            for (i in 11..n) {
                dp[i] = dp[i - 1] + dp[i - 5]
            }

            println(dp[n])
        }
    }
}