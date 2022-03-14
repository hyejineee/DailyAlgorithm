package BOJ

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import kotlin.math.min

fun main() {
    with(BufferedReader(InputStreamReader(System.`in`))) {
        for (t in 0 until readLine().toInt()) {
            val n = readLine().toInt()
            val files = listOf(0) + readLine().split(" ").map { it.toInt() }
            val acc = MutableList(n + 1) { 0 }

            for (i in files.indices) {
                acc[i] = if (i - 1 in files.indices) acc[i - 1] + files[i] else 0
            }

            val dp = MutableList(n + 1) {
                MutableList(n + 1) { 0 }
            }

            for (i in 2 until n + 1) {
                for (j in 1 until n + 2 - i) {

                    var min = 0
                    (0 until i - 1).forEach() { k ->
                        min = if(min == 0 ){
                            dp[j][j + k] + dp[j + k + 1][j + i - 1]
                        }else{
                            min(dp[j][j + k] + dp[j + k + 1][j + i - 1], min)
                        }
                    }

                    dp[j][j + i - 1] = min + (acc[j + i - 1] - acc[j - 1])
                }
            }

            println(dp[1][n])
        }
    }
}