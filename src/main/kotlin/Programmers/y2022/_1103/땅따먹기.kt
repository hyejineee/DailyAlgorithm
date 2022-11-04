package Programmers.y2022._1103

import kotlin.math.max

fun 땅따먹기(land: Array<IntArray>): Int? {
    val dp = Array(land.size) { i -> IntArray(4) { j -> land[i][j] } }

    for (i in 1 until land.size) {
        for (j in 0 until 4) {
            for (k in 0 until 4) {
                if (j == k) continue
                dp[i][j] = max(dp[i][j], land[i][j] + dp[i - 1][k])
            }
        }
    }
    return dp[dp.size - 1].maxOrNull()
}