package BOJ


import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main() {
    with(BufferedReader(InputStreamReader(System.`in`))) {
        val bw = BufferedWriter(OutputStreamWriter(System.out))

        val n = readLine().toInt()
        val t = (0 until n).map { readLine().toInt() }

        var right = 1
        var h = t[0]
        for (i in 1 until t.size) {
            if (h < t[i]) {
                h = t[i]
                right++
            }
        }

        val reversed = t.reversed()
        h = reversed[0]
        var left = 1
        for (i in 1 until reversed.size) {
            if (h < reversed[i]) {
                h = reversed[i]
                left++
            }
        }

        bw.write("$right\n$left")
        bw.flush()
        bw.close()
    }
}