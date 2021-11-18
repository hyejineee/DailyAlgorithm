package BOJ

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

fun main() {
    with(BufferedReader(InputStreamReader(System.`in`))) {
        val n = readLine().toInt()
        val board = MutableList(n){
            readLine().split(" ").map { it.toInt() }.toIntArray()
        }
        println(dfs(n, board, 5))
    }
}

private fun compress(list: IntArray, n:Int ): IntArray {
    var new = list.filter { it != 0 }.toIntArray()
    for (i in 1 until new.size){
        if(new[i-1] == new[i]){
            new[i-1] *=2
            new[i] = 0
        }
    }
    new = new.filter { it!=0 }.toIntArray()
    return new + IntArray(n-new.size){0}
}

private fun rotate90(board: MutableList<IntArray>, n:Int){
    val temp = MutableList(n){IntArray(n){0} }
    for(i in 0 until n){
        for (j in 0 until n){
            temp[j][n-i-1] = board[i][j]
        }
    }

    board.clear()
    board.addAll(temp)
}

private fun dfs(n:Int, board:MutableList<IntArray>, count:Int): Int {
    var max = board.flatMap { it.toList() }.maxOrNull()?:-1
    if(count== 0) {
        return max
    }

    for(i in 0 until 4){
        val compressedBoard = board.map {
            compress(it,n)
        }

        if(!Arrays.deepEquals(compressedBoard.toTypedArray(), board.toTypedArray())){
            max = maxOf(max, dfs(n, compressedBoard.toMutableList(), count-1))
        }

        rotate90(board, n)
    }

    return max
}