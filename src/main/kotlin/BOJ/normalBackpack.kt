package BOJ

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main() {
    with(BufferedReader(InputStreamReader(System.`in`))) {
        val bw = BufferedWriter(OutputStreamWriter(System.out))

        val (n, k) = readLine().split(" ").map { it.toInt() }

        val dp = MutableList(n + 1) { MutableList(k + 1) { 0 } }

        (1..n).forEachIndexed { _, i ->
            val (w, v) = readLine().split(" ").map { it.toInt() }

            for (j in 1..k) {
                if (j < w) {
                    dp[i][j] = dp[i - 1][j]
                } else {
                    dp[i][j] = maxOf(dp[i - 1][j], dp[i - 1][j - w] + v)
                }
            }
        }

        bw.write("${dp[n][k]}")

        bw.flush()
        bw.close()
    }
}



