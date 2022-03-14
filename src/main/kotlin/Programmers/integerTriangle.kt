package Programmers

fun integerTriangle(triangle: Array<IntArray>): Int {

    val dp = Array(triangle.size + 1) { i ->
        IntArray(triangle.size + 1) { j ->
            if (i == 0) {
                0
            } else if (j == 0) {
                0
            } else {
                triangle[i - 1][j - 1]
            }
        }
    }

    for(i in 2 until dp.size){
        for(j in 1 .. i){
            dp[i][j] = maxOf(dp[i-1][j-1] + dp[i][j], dp[i-1][j] + dp[i][j])
        }
    }


    return dp.last().maxBy { it }?:-1
}