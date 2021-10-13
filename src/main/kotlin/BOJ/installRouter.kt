package BOJ

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter


fun main() {

    with(BufferedReader(InputStreamReader(System.`in`))) {
        val bw = BufferedWriter(OutputStreamWriter(System.out))

        val (n, c) = readLine().split(" ").map { it.toInt() }

        val houses = (0 until n).map {
            readLine().toInt()
        }.sorted()

        var start = houses[1] - houses[0]
        var end = houses.last() - houses[0]
        var result = 0

        while (start <= end) {
            val mid = (start + end) / 2
            var installed = houses[0]
            var count = 1

            for (i in 1 until n) {
                if (houses[i] >= installed + mid) {
                    installed = houses[i]
                    count += 1
                }
            }

            if (count >= c) {
                start = mid + 1
                result = mid
            } else {
                end = mid - 1
            }
        }

        bw.write("$result")

        bw.flush()
        bw.close()
    }
}