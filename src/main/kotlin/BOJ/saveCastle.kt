package BOJ


import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main() {
    with(BufferedReader(InputStreamReader(System.`in`))) {
        val bw = BufferedWriter(OutputStreamWriter(System.out))

        val (n, m) = readLine().split(" ").map { it.toInt() }

        val c = MutableList(n) {
            readLine().toCharArray()
        }

        val r = MutableList(m) { i ->
            MutableList(n) { j ->
                c[j][i]
            }
        }

        bw.write("${maxOf(c.filter { 'X' !in it }.count(), r.filter { 'X' !in it }.count())}")
        bw.flush()
        bw.close()
    }
}