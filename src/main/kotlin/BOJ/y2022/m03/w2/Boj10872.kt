package BOJ


import java.io.BufferedReader
import java.io.InputStreamReader


fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val n = readLine().toInt()

    println((n downTo 1).fold(1){acc, i -> acc *i })
}


