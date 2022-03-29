package BOJ.y2022.m03.w5


import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    with(BufferedReader(InputStreamReader(System.`in`))) {
        val n = readLine().toInt()

        if(n ==1){
            println("1")
            System.exit(0)
        }

        val dp = IntArray(n+1){0}
        dp[1] = 1
        dp[2] = 2

        for (i in 3 ..n){
            dp[i] = (dp[i-1] + dp[i-2]) % 15746
        }

        println(dp[n])
    }
}