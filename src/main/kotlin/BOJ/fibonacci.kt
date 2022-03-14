package BOJ


import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main() {
    with(BufferedReader(InputStreamReader(System.`in`))) {
        val bw = BufferedWriter(OutputStreamWriter(System.out))

        val n = readLine().toInt()
        val arr = MutableList(n + 1) {
            when (it) {
                1 -> 1
                else -> 0
            }
        }

        var count = 2

        while (count < n + 1) {
            arr[count] = arr[count - 1] + arr[count - 2]
            count++
        }

        bw.write("${arr[n]}")

        bw.flush()
        bw.close()
    }
}