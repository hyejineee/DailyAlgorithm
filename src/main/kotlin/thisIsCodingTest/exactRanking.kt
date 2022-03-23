package thisIsCodingTest

import kotlin.math.min

fun exactRanking(n: Int, result: Array<IntArray>): Int {
    val MAX = 1000000
    val dp = Array(n + 1) { i -> IntArray(n + 1) { j -> if (i == j) 0 else MAX } }


    result.forEach { (a, b) ->
        dp[a][b] = 1
    }

    for (k in 1..n) {
        for (i in 1..n) {
            for (j in 1..n) {
                dp[i][j] = minOf(dp[i][j], dp[i][k] + dp[k][j])
            }
        }
    }
    dp.forEach { println(it.toList()) }
    var answer = 0
    for (i in 1..n) {
        var count = 0
        for (j in 1..n) {
            if (dp[i][j] != MAX || dp[j][i] != MAX) count++
        }

        if (count == n) {
            answer++
        }
    }

    return answer
}