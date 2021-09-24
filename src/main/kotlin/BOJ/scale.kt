package BOJ

import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.abs

// https://www.acmicpc.net/problem/2920

fun main() {

    with(BufferedReader(InputStreamReader(System.`in`))) {
        val numbers = readLine().split(" ").map { it.toInt() }.toIntArray()
        println(scale(numbers))
    }
}

fun scale(numbers: IntArray): String {
    for (i in 1 until numbers.size) {
        if (abs(numbers[i - 1] - numbers[i]) != 1) {
            return "mixed"
        }
    }

    return if (numbers.first() == 1) "ascending" else "descending"
}