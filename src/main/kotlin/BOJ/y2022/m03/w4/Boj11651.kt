package BOJ

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import kotlin.math.abs

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {

    (0 until readLine().toInt())
        .map { readLine().split(" ").map { it.toInt() } }
        .sortedWith(compareBy({ it[1] }, { it[0] }))
        .forEach { (x, y) -> println("$x $y") }

}

