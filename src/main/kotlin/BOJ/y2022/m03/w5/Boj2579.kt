package BOJ.y2022.m03.w5


import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.max

fun main() {
    with(BufferedReader(InputStreamReader(System.`in`))) {
        val n = readLine().toInt()
        val arr = (0 until n).map { readLine().toInt() }.toIntArray()

        if (n == 1) {
            println(arr[0])
            System.exit(0)
        }

        if (n == 2) {
            println(max(arr[1], arr[0] + arr[1]))
            System.exit(0)
        }

        val dp = IntArray(n ) { 0 }
        dp[0] = arr[0]
        dp[1] = maxOf(arr[1], arr[0] + arr[1])
        dp[2] = maxOf(arr[2] + arr[0], arr[2] + arr[1])

        for (i in 3 until n) {
            dp[i] = max(arr[i] + dp[i - 2], arr[i] + arr[i - 1] + dp[i - 3])
        }

        println(dp.last())
    }
}