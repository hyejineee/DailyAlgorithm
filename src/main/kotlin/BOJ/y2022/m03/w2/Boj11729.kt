package BOJ


import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import kotlin.math.PI
import kotlin.math.abs
import kotlin.math.pow
import kotlin.math.sqrt

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {

    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val n = readLine().toInt()
    val result = mutableListOf<String>()
    hanoi(n, 1, 3, 2, result)
    println(result.size)
    println(result.joinToString("\n"))

}

private fun hanoi(n: Int, from: Int, to: Int, temp: Int, result: MutableList<String>) {
    if (n == 1) {
        result.add("$from $to")
        return
    }

    hanoi(n - 1, from, temp, to, result)
    result.add("$from $to")
    hanoi(n - 1, temp, to, from, result)
}

