package BOJ


import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main() {
    with(BufferedReader(InputStreamReader(System.`in`))) {
        val bw = BufferedWriter(OutputStreamWriter(System.out))

        var d = readLine()
        val w = readLine()

        var count = 0
        while (d.length >= w.length) {
            if (d.startsWith(w)) {
                d = d.drop(w.length)
                count++
            } else {
                d = d.drop(1)
            }
        }

        bw.write("$count")

        bw.flush()
        bw.close()
    }
}