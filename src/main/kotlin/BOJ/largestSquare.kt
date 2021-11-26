package BOJ

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main() {
    with(BufferedReader(InputStreamReader(System.`in`))) {
        val (n, m) = readLine().split(" ").map { it.toInt() }
        val arr = MutableList(n + 1) {
            if (it == 0)
                MutableList(m + 1) { 0 }
            else
                readLine().map { Character.getNumericValue(it) }.toMutableList().apply {
                    add(0, 0)
                }
        }

        val dp = arr.toMutableList()

        for (i in 1..n) {
            for (j in 1..m) {
                if (arr[i][j] != 0) {
                    dp[i][j] =
                        minOf(dp[i - 1][j], dp[i - 1][j - 1], dp[i][j - 1]) + 1
                }
            }
        }

        val max = dp.flatten().maxOrNull() ?: 0
        println(max * max)
    }
}