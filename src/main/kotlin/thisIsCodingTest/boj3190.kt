package thisIsCodingTest

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val n = readLine().toInt()
    val apples = (0 until readLine().toInt()).map { readLine().split(" ").map { it.toInt() } }
    var directions = (0 until readLine().toInt()).map { readLine().split(" ") }

    val board = Array(n + 1) { IntArray(n + 1) { 0 } }
    board[1][1] = -1

    apples.forEach { (i, j) -> board[i][j] = 1 }


    var time = 0
    var currentD = 'R'
    val snake = LinkedList<IntArray>().apply {
        add(intArrayOf(1, 1))
    }
    var head = intArrayOf(1, 1)

    while (true) {

        val (nx, ny) = move(currentD, head)

        //다음 칸이 벽이나 자기 몸인 경우
        if ((nx in 1..n && ny in 1..n).not()) break
        if (board[nx][ny] == -1) break

        if (board[nx][ny] == 0) {
            board[nx][ny] = -1
            snake.add(intArrayOf(nx, ny))

            println("tail : ${snake.map { it.toList() }}")
            val (x, y) = snake.pollFirst()
            board[x][y] = 0

        }

        if (board[nx][ny] == -1) {
            board[nx][ny] = -1
            snake.add(intArrayOf(nx, ny))
        }

        time++
        head = intArrayOf(nx,ny)

        println("time : $time")
        board.forEach { println(it.toList()) }

        if (directions.isNotEmpty() && directions.first()[0].toInt() == time) {
            val d = directions.first()[1]
            currentD = if (d == "D") turnRight(currentD) else turnLeft(currentD)
            directions = directions.drop(1)
        }
    }

    println(time)
}

private fun turnRight(currentDirection: Char) = when (currentDirection) {
    'R' -> 'D'
    'L' -> 'U'
    'U' -> 'L'
    else -> 'R'
}

private fun turnLeft(currentDirection: Char) = when (currentDirection) {
    'R' -> 'U'
    'L' -> 'D'
    'U' -> 'R'
    else -> 'L'
}

private fun move(direction: Char, currentPosition: IntArray) = when (direction) {
    'R' -> intArrayOf(currentPosition[0], currentPosition[1] + 1)
    'L' -> intArrayOf(currentPosition[0], currentPosition[1] - 1)
    'U' -> intArrayOf(currentPosition[0] - 1, currentPosition[1])
    else -> intArrayOf(currentPosition[0] + 1, currentPosition[1])
}
