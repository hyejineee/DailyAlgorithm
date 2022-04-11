package BOJ


import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main() {
    with(BufferedReader(InputStreamReader(System.`in`))) {
        val n = readLine().toInt()
        val arr = IntArray(501) { 0 }
        (0 until n).map {
            val (index, num) = readLine().split(" ").map { it.toInt() }
            arr[index] = num
        }

        val dp = IntArray(501) { if (arr[it] == 0) 0 else 1 }

        for (i in 0 until 501) {
            if (arr[i] == 0) continue
            for (j in 0..i) {
                if (arr[j] > arr[i]) {
                    dp[i] = maxOf(dp[i], dp[j] + 1)
                }
            }
        }

        println(dp.maxOrNull() ?: -1)

    }
}

