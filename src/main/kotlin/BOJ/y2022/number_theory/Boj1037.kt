package BOJ


import java.io.BufferedReader
import java.io.InputStreamReader


fun main() {
    with(BufferedReader(InputStreamReader(System.`in`))) {
        val n = readLine().toInt()
        val arr = readLine().split(" ").map { it.toInt() }.sorted()
        println(arr.first() * arr.last())
    }
}

