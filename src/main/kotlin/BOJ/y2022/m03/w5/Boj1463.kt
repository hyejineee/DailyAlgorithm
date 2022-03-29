package BOJ.y2022.m03.w5


import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.min

fun main() {
    with(BufferedReader(InputStreamReader(System.`in`))) {
        val n = readLine().toInt()

        if (n == 1) {
            println(0)
            System.exit(0)
        }

        if (n == 2) {
            println(1)
            System.exit(0)
        }

        val dp = IntArray(n + 1) { Int.MAX_VALUE }
        dp[2] = 1
        dp[3] = 1

        for (i in 4..n) {
            if (i % 2 == 0) {
                dp[i] = min(dp[i], dp[i / 2] + 1)
            }

            if (i % 3 == 0) {
                dp[i] = min(dp[i], dp[i / 3] + 1)
            }

            dp[i] = min(dp[i], dp[i - 1] + 1)
        }

        println(dp[n])
    }
}

