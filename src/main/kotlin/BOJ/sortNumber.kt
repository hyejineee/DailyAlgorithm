package BOJ

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main() {
    with(BufferedReader(InputStreamReader(System.`in`))) {
        val bw = BufferedWriter(OutputStreamWriter(System.out))

        val n = readLine().toInt()

        val arr = (0 until n).map {
            readLine().toInt()
        }

        arr.sorted().map {
            bw.write("$it\n")
        }

        bw.flush()
        bw.close()
    }
}