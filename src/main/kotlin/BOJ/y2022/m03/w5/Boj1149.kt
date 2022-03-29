package BOJ.y2022.m03.w5


import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.cos
import kotlin.math.min

fun main() {
    with(BufferedReader(InputStreamReader(System.`in`))) {
        val dp = (0 until readLine().toInt()).map { readLine().split(" ").map { it.toInt() }.toIntArray() }
        val n = dp.size

        for (i in 1 until n){
            for(j in 0 until 3){
                val min = findMin(dp[i-1], j)
                dp[i][j] = dp[i][j] + min
            }
        }

        println(dp.last().minOrNull()?:-1)
    }
}

private fun findMin(cost: IntArray, excepted: Int? = null): Int {
    var min = 1001 * 1001
    for (i in 0 until 3) {
        if (excepted != null && i == excepted) continue
        min = min(min, cost[i])
    }
    return  min
}

