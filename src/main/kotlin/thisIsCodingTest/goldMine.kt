package thisIsCodingTest

import kotlin.math.max

fun goldMine(n: Int, m: Int, gold: IntArray): Int {

    val dp = Array<IntArray>(n) { IntArray(m) { 0 } }

    //금광 초기화 & 제일 큰 수 찾기
    var max = 0
    var maxIndex = 0
    for (i in 0 until n) {
        dp[i][0] = gold[((m) * i)]
    }

    for (j in 1 until m) {
        for (i in 0 until n) {

            val leftUp = if (i - 1 in 0 until n) dp[i - 1][j - 1] else 0
            val leftDown = if (i + 1 in 0 until n) dp[i + 1][j - 1] else 0
            val left = dp[i][j - 1]

            dp[i][j] = gold[j + ((m) * i)] + maxOf(left, leftUp, leftDown)

            println("i$i, j:$j, dp:${dp[i][j]}")
        }
    }

    dp.forEach { println(it.toList()) }



    return dp.flatMap { it.toList() }.maxOrNull() ?: -1
}