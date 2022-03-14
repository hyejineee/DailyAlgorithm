package BOJ

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main() {
    with(BufferedReader(InputStreamReader(System.`in`))) {
        val bw = BufferedWriter(OutputStreamWriter(System.out))

        val n = readLine().toInt()
        val dp = MutableList(1000001){0}

        dp[1]= 1
        dp[2]= 2

        for(i in 3..n){
            dp[i] = (dp[i-1] + dp[i-2]) % 15746
        }

        bw.write(dp[n].toString())

        bw.flush()
        bw.close()
    }
}