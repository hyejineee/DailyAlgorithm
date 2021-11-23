package BOJ

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main() {
    with(BufferedReader(InputStreamReader(System.`in`))) {
        val (n,m) = readLine().split(" ").map { it.toInt() }
        val arr = Array(n){
            readLine().split(" ").map { it.toInt() }.toIntArray()
        }

        val dp = MutableList(n+1){
            MutableList(m+1){0}
        }

        for(i in 1..n){
            for(j in 1..m){
                dp[i][j] = dp[i][j-1] + dp[i-1][j] - dp[i-1][j-1] + arr[i-1][j-1]
            }
        }

        val k = readLine().toInt()

        (1..k).forEach {
            val (i,j,x,y) = readLine().split(" ").map { it.toInt() }

            println(dp[x][y] - dp[i-1][y] - dp[x][j-1] + dp[i-1][j-1])
        }
    }
}