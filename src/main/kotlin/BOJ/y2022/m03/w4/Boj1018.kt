package BOJ


import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.min

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val (n, m) = readLine().split(" ").map { it.toInt() }
    val board = Array<CharArray>(n) { readLine().toCharArray() }

    val b = charArrayOf('B', 'W', 'B', 'W', 'B', 'W', 'B', 'W')
    val w = charArrayOf('W', 'B', 'W', 'B', 'W', 'B', 'W', 'B')

    val wb = Array(8) { i -> if ((i + 1) % 2 != 0) w else b }
    val bb = Array(8) { i -> if ((i + 1) % 2 != 0) b else w }

    var min = 100
    for (i in 0 .. n - 8) {
        for (j in 0 .. m - 8) {
            val wCount = counting(board, wb ,i,j)
            val bCount = counting(board, bb, i,j)
            min = minOf(min, wCount, bCount)
        }
    }
    println(if(min == 100) 0 else min)

}

private fun counting(board:Array<CharArray>, colorB:Array<CharArray>,x:Int, y:Int): Int {
    var count =0
    for(i in 0 until 8){
        for (j in 0 until 8){
            if(board[x+i][y+j] != colorB[i][j]) count++
        }
    }

    return count
}

