package BOJ


import java.awt.SystemTray
import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

// https://www.acmicpc.net/problem/2798


fun main() {

    with(BufferedReader(InputStreamReader(System.`in`))) {
        val bw = BufferedWriter(OutputStreamWriter(System.out))

        val (n,k) = readLine().split(" ").map { it.toInt() }
        val dp = MutableList(n+1){
            MutableList(k+1){0}
        }

        for(i in 1..n){
            val (w, v) = readLine().split(" ").map { it.toInt() }

            for(j in 1..k){
                if(j >= w){
                    dp[i][j] = maxOf(dp[i-1][j], dp[i-1][j-w]+v)
                }else{
                    dp[i][j] = dp[i-1][j]
                }
            }
        }

        println(dp.flatten().maxOrNull()?:-1)
    }
}

