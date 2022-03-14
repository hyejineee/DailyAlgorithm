package BOJ

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter


fun main() {

    with(BufferedReader(InputStreamReader(System.`in`))) {
        val bw = BufferedWriter(OutputStreamWriter(System.out))

        val n = readLine().toInt()

        var remained = n
        var count = 0

        var sing = 1
        while (remained > 0) {
            if (remained >= sing) {
                remained -= sing
                count++
                sing++
            } else {
                sing = 1
            }
        }

        bw.write("$count")

        bw.flush()
        bw.close()
    }
}