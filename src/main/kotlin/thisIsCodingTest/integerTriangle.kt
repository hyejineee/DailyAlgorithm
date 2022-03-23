package thisIsCodingTest

import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.max

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val n = readLine().toInt()
    val t = (1..n).map { readLine().split(" ").map { it.toInt() }.toIntArray() }.toTypedArray()

    println(integerTriangle(n, t))
}

fun integerTriangle(n:Int, triangle:Array<IntArray>):Int{
    val dp = Array(n+1){IntArray(n+1){0}}

    for (i in 1..n){
        for (j in 1..triangle[i-1].size){
            dp[i][j] = triangle[i-1][j-1]
        }
    }

    for (i in 2..n){
        for (j in 1..i){
            dp[i][j] = dp[i][j] + max(dp[i-1][j-1], dp[i-1][j])
        }
    }

    return dp[n].maxOrNull()?:-1
}