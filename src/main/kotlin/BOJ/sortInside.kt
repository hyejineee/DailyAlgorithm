package BOJ


import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main() {
    with(BufferedReader(InputStreamReader(System.`in`))) {
        val bw = BufferedWriter(OutputStreamWriter(System.out))

        val n = readLine().toInt()

        (0 until n).map {
            val (age, name) = readLine().split(" ")

            Pair(age.toInt(), name)
        }.sortedBy { it.first }.map {
            bw.write("${it.first} ${it.second}\n")
        }

        bw.flush()
        bw.close()
    }
}