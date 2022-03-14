package BOJ

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import kotlin.math.max

fun main() {
    with(BufferedReader(InputStreamReader(System.`in`))) {
        val n = readLine().toInt()
        val triangle = mutableListOf<IntArray>(intArrayOf(0))
        (1..n).forEach {
            val arr = intArrayOf(0) + readLine().split(" ").map { it.toInt() }.toIntArray()
            triangle.add(arr)
        }
        val dp = Array(n+1){
            IntArray(n+1){0}
        }

        for(i in 1 .. n){
            for(j in 1 until triangle[i].size){
                val l = triangle[i][j] + dp[i-1][j]
                val r = triangle[i][j] + dp[i-1][j-1]
                dp[i][j] = max(l, r)
            }
        }

        println(dp.last().maxOrNull()?:-1)
    }
}