package BOJ.y2022.m03.w5


import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.abs

fun main() {
    with(BufferedReader(InputStreamReader(System.`in`))) {
        val n = readLine().toInt()

        val result = mutableListOf<Int>()
        dfs(0, n, mutableListOf(), result)

        println(result.size / n)
    }
}

private fun dfs(currentRow: Int, n: Int, candidates: MutableList<Int>, result: MutableList<Int>) {

    if (currentRow == n) {
        result.addAll(candidates.toList())
        return
    }

    for (i in 0 until n) {
        if (isAvailable(candidates, i)) {
            candidates.add(i)
            dfs(currentRow + 1, n, candidates, result)
            candidates.removeLast()
        }
    }

}

private fun isAvailable(candidates: MutableList<Int>, currentCol: Int): Boolean {
    val currentRow = candidates.size

    for (i in 0 until currentRow) {
        if (candidates[i] == currentCol || abs(candidates[i] - currentCol) == (currentRow - i)) {
            return false
        }
    }
    return true
}