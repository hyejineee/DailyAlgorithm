package BOJ

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main() {
    with(BufferedReader(InputStreamReader(System.`in`))) {
        val n = readLine()
        val s = "1".repeat(n.length)

        if (n.length == 1) {
            println(1)
        } else if (n.toLong() >= s.toLong()) {
            println(n.length)
        } else {
            println(n.length - 1)
        }
    }
}