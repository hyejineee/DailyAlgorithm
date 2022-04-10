package BOJ


import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main() {
    with(BufferedReader(InputStreamReader(System.`in`))) {
        val n = readLine().toInt()
        val arr = readLine().split(" ").map { it.toInt() }
        val dp1 = IntArray(n) { 1 }
        val dp2 = IntArray(n) { 1 }

        for (i in 0 until n) {
            for (j in 0..i) {
                if (arr[j] < arr[i]) {
                    dp1[i] = maxOf(dp1[i], dp1[j] + 1)
                }
            }
        }

        for (i in n - 1 downTo 0) {
            for (j in n - 1 downTo i) {
                if (arr[j] < arr[i]) {
                    dp2[i] = maxOf(dp2[i], dp2[j] + 1)
                }
            }
        }

        val new = dp1.zip(dp2) { a, b -> a + b }
        println((new.maxOrNull() ?: -1) - 1)
    }
}

