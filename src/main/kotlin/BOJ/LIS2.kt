package BOJ

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main() {
    with(BufferedReader(InputStreamReader(System.`in`))) {
        val bw = BufferedWriter(OutputStreamWriter(System.out))

        val n = readLine().toInt()
        val arr = readLine().split(" ").map { it.toInt() }
        val dp = MutableList(n){1}

        for(i in arr.indices){
            for(j in 0 ..i){
                if(arr[j] < arr[i]){
                    dp[i] = maxOf(dp[i], dp[j] + 1)
                }
            }
        }

        bw.write((dp.maxOrNull()?:0).toString())

        bw.flush()
        bw.close()
    }
}