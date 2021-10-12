package Problems

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {

    with(BufferedReader(InputStreamReader(System.`in`))) {
        val (n, m) = readLine().split(" ").map { it.toInt() }
        val board = readLines().toTypedArray()

        val result = mutableListOf<String>()
        dfs(board, mutableListOf(board[0][0]), 0, 0, result)

        println(result.last().length)
    }
}

fun alphabet(board: Array<String>): Int {
    val result = mutableListOf<String>()
    dfs(board, mutableListOf(board[0][0]), 0, 0, result)
    return result.last().length
}

fun dfs(
    board: Array<String>,
    currentCandidate: MutableList<Char>,
    currentRow: Int,
    currentCol: Int,
    result: MutableList<String>
) {

    if ((result.maxOfOrNull { it.length } ?: 0) < currentCandidate.size) {
        result.add(currentCandidate.joinToString(""))
    }

    val coordinate = listOf(
        intArrayOf(-1, 0),
        intArrayOf(1, 0),
        intArrayOf(0, -1),
        intArrayOf(0, 1),
    )

    for (i in coordinate) {

        val x = currentRow + i[0]
        val y = currentCol + i[1]

        if (x !in board.indices || y !in 0 until board[0].length) continue

        if (board[x][y] !in currentCandidate) {
            currentCandidate.add(board[x][y])
            dfs(board, currentCandidate, x, y, result)
            currentCandidate.removeLast()
        }
    }
}

