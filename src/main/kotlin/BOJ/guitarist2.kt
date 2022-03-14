package BOJ

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main() {
    with(BufferedReader(InputStreamReader(System.`in`))) {
        val bw = BufferedWriter(OutputStreamWriter(System.out))

        val (n,s,m) = readLine().split(" ").map { it.toInt() }
        val v = readLine().split(" ").map { it.toInt() }
        val dp = MutableList(n+1){
            MutableList(m+1){false}
        }

        dp[0][s] = true

        for(i in 1 .. n){

            val currentV = v[i-1]

            for(j in 0 .. m){
                if (!dp[i-1][j]) continue

                if(j - currentV >=0) dp[i][j- currentV] = true
                if(j + currentV <=m) dp[i][j + currentV] = true

            }
        }

        var result = -1

//        println(dp)
        for(i in m downTo 0){
            if(dp[n][i]){
                result = i
                break
            }
        }

        println(result)

        bw.flush()
        bw.close()
    }
}