package BOJ


import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val (x, y, w, h) = readLine().split(" ").map { it.toInt() }
    bw.write("${minOf(x, y, w - x, h - y)}")
    bw.flush()
    bw.close()
}

