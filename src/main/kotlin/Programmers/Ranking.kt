package Programmers

import java.util.*

fun ranking(n: Int, results: Array<IntArray>): Int {
    val board = Array(n) {CharArray(n){'x'} }

    results.forEach {
        val (a, b) = it
        board[a - 1][b - 1] = 'w'
        board[b - 1][a - 1] = 'l'
    }

    for (k in 0 until n) {
        for(i in 0 until n){
            for(j in 0 until n){
                if(board[i][k] == board[k][j] && board[i][k] != 'x'){
                    board[i][j] = board[i][k]
                }
            }
        }
    }
    return  board.filter { arr -> arr.count { it =='x'} ==1 }.size
}
