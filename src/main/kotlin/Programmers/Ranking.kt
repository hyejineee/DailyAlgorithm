package Programmers

import java.util.*
import kotlin.math.cos
import kotlin.math.min

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
    floyd()
    return  board.filter { arr -> arr.count { it =='x'} ==1 }.size
}

fun floyd(){

    val inf = 10000000
    val nodeCount = 5
    val graph = arrayOf(
        intArrayOf(3,4,7),
        intArrayOf(3,2,2),
        intArrayOf(2,1,5),
        intArrayOf(1,4,9),
        intArrayOf(4,5,2),
        intArrayOf(1,5,1)
    )


    val distances = Array(5+1){ i->
        IntArray(5+1){ j ->
            if(i==j) 0 else inf
        }
    }

    graph.forEach {
        val (a, b, cost) = it
        distances[a][b] = cost
        distances[b][a] = cost
    }

    for (k in 1..nodeCount){
        for(i in 1..nodeCount){
            for (j in 1..nodeCount){
                distances[i][j] = min(distances[i][j],  distances[i][k] + distances[k][j])
            }
        }
    }
}
