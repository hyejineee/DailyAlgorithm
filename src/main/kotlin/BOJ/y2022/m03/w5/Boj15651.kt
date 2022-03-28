package BOJ.y2022.m03.w5


import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val (n, m) = readLine().split(" ").map { it.toInt() }

    for (i in 1..n) {
        combination(m, m - 1, BooleanArray(n + 1), mutableListOf(i), n)
    }

}

private fun combination(
    level: Int,
    curLevel: Int,
    visited: BooleanArray,
    arr: MutableList<Int>,
    range: Int
) {
    if (curLevel == 0) {
        println(arr.joinToString(" "))
        return
    } else {
        for (i in 1..range) {
            arr.add(i)
            combination(level, curLevel - 1, visited, arr, range)
            arr.removeLast()
        }
    }
}