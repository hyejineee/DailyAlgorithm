package BOJ


import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main() {
    with(BufferedReader(InputStreamReader(System.`in`))) {
        val bw = BufferedWriter(OutputStreamWriter(System.out))

        val (n, k) = readLine().split(" ").map { it.toInt() }
        bw.write("${readLine().split(" ").map { it.toInt() }.sorted()[k - 1]}")
        bw.flush()
        bw.close()
    }
}