package Ds

import kotlin.math.abs

fun main() {
    nQueen(4)
}

fun nQueen(n: Int): MutableList<Int> {

    val finalResult = mutableListOf<Int>()
    dfs(n, 0, mutableListOf<Int>(), finalResult)
    return finalResult
}

fun dfs(n: Int, currentRow: Int, currentCandidate: MutableList<Int>, result: MutableList<Int>) {

    if (currentRow == n) {
        result.addAll(currentCandidate.toList())
        return
    }

    for (i in 0 until n) {
        if (isAvailable(currentCandidate, i)) {
            currentCandidate.add(i)
            dfs(n, currentRow + 1, currentCandidate, result)
            currentCandidate.removeLast()
        }
    }
}

fun isAvailable(currentCandidate: MutableList<Int>, currentCol: Int): Boolean {
    val currentRow = currentCandidate.size

    for (q in 0 until currentRow) {
        if (currentCandidate[q] == currentCol || abs(currentCandidate[q] - currentCol) == currentRow - q) {
            return false
        }
    }
    return true
}