package thisIsCodingTest

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun luckyStraight(n: Long): String = with(n.toString()) {
    val l = this.substring(0, this.length / 2).fold(0) { acc: Int, c: Char -> acc + Character.getNumericValue(c) }
    val r =
        this.substring(this.length / 2, this.length).fold(0) { acc: Int, c: Char -> acc + Character.getNumericValue(c) }

    if (r == l) "LUCKY" else "READY"
}

fun main() {
    with(BufferedReader(InputStreamReader(System.`in`))) {
        val bw = BufferedWriter(OutputStreamWriter(System.out))
        val n = readLine().toLong()

        val result = with(n.toString()) {
            val l = this.substring(0, this.length / 2).fold(0) { acc: Int, c: Char -> acc + java.lang.Character.getNumericValue(c) }
            val r =
                this.substring(this.length / 2, this.length).fold(0) { acc: Int, c: Char -> acc + java.lang.Character.getNumericValue(c) }

            if (r == l) "LUCKY" else "READY"
        }


        bw.write("$result")
        bw.flush()
        bw.close()
    }
}