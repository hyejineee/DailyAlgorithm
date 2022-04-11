package BOJ


import java.io.BufferedReader
import java.io.InputStreamReader


fun main() {
    with(BufferedReader(InputStreamReader(System.`in`))) {
        val n = readLine().toInt()
        val arr = readLine().split(" ").map { it.toInt() }
        val dp = IntArray(n) { 0 }
        dp[0] = arr[0]

        for (i in 1 until n) {
            dp[i] = maxOf(dp[i - 1] + arr[i], arr[i - 1] + arr[i], arr[i])
        }
//        println(dp.toList())
        println(dp.maxOrNull() ?: -1)
    }
}

