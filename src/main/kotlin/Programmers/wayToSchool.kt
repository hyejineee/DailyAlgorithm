package Programmers

fun wayToSchool(m: Int, n: Int, puddles: Array<IntArray>): Int {
    val dp = Array(n + 1) { i ->
        IntArray(m + 1) { j ->
            if (i == 1&& j == 1) {
                1
            } else {
                0
            }
        }
    }


    puddles.forEach { (j, i) ->
        dp[i][j] = -1
    }


    for (i in 1..n) {
        for (j in 1..m) {
            if (dp[i][j] == -1 || dp[i][j] == 1 ) continue

            val a = if (dp[i - 1][j] == -1) 0 else dp[i - 1][j]
            val b = if (dp[i][j - 1] == -1) 0 else dp[i][j - 1]

            dp[i][j] = (a+b)%1000000007
        }
    }

    dp.forEach {
        println(it.toList())
    }

    return dp[n][m]
}