package BOJ

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import kotlin.math.abs

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {

    (0 until readLine().toInt())
        .mapIndexed { index, _ -> index to readLine().split(" ") }
        .sortedWith(compareBy({ it.second[0].toInt() }, { it.first }))
        .forEach { println("${it.second[0]} ${it.second[1]}") }
}

