package BOJ

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import kotlin.math.abs

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {

    (0 until readLine().toInt())
        .map { readLine() }
        .toSet()
        .sortedWith(compareBy({ it.length }, { it }))
        .forEach { println(it) }
}

