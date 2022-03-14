package BOJ

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main() = with(BufferedReader(InputStreamReader(System.`in`))){
    val n = readLine().toInt()
    val b = readLine().split(" ").map { it.toInt() }

    val result = mutableListOf<Int>()

    b.forEachIndexed { i, _ ->
        result.add((b[i] * (i+1)) - result.sum())
    }

    println(result.joinToString(" "))
}
