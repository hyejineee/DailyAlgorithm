package BOJ


import java.io.BufferedReader
import java.io.InputStreamReader

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val n = readLine().toInt()
    (1..n).map { readLine().toInt() }.sorted().forEach { println(it) }
}

