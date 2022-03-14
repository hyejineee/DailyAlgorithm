package BOJ

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main() = with(BufferedReader(InputStreamReader(System.`in`))){
    val n = readLine().toInt()
    val scores = readLine().split(" ").map { it.toInt() }

    println((scores.maxOrNull()?:0) - (scores.minOrNull()?:0))
}
