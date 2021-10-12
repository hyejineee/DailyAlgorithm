package BOJ


import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main() {
    with(BufferedReader(InputStreamReader(System.`in`))) {
        val bw = BufferedWriter(OutputStreamWriter(System.out))

        val n = readLine().toInt()

        val record = mutableMapOf<String, Int>()
        (0 until n).forEach {
            val title = readLine()
            record[title] = record[title]?.plus(1) ?: 1
        }

        bw.write("${record.toSortedMap().maxByOrNull { it.value }?.key}")

        bw.flush()
        bw.close()
    }
}