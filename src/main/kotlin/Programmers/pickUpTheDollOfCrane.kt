package Programmers

import java.util.*

fun pickUpTheDollOfCrane(board: Array<IntArray>, moves: IntArray): Int {
    val queueBoard = List<LinkedList<Int>>(board.size) {
        LinkedList()
    }

    for (i in board.indices) {
        for (j in board[i].indices) {
            if (board[i][j] == 0) continue
            queueBoard[j].push(board[i][j])
        }
    }

    val basket = Stack<Int>()

    var popCount = 0

    for (i in moves) {

        if (queueBoard[i - 1].isEmpty()) continue

        val doll = queueBoard[i - 1].pollLast()
        val prevDoll = if (basket.isNotEmpty()) basket.peek() else -1

        if (doll == prevDoll) {
            basket.pop()
            popCount += 2
            continue
        }

        basket.push(doll)
    }
    return popCount
}