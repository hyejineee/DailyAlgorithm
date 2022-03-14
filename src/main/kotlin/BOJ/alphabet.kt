package BOJ


import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*

fun main() {
    with(BufferedReader(InputStreamReader(System.`in`))) {
        val (r,c) = readLine().split(" ").map { it.toInt() }
        val board:List<String> = (0 until r).map { readLine() }
        println(bfs(board))

    }
}

private fun bfs(board:List<String>): Int {
    var result = 0

    val needVisit = mutableSetOf<Triple<Int, Int, String>>()
    needVisit.add(Triple(0,0,""+ board[0][0]))

    while (needVisit.isNotEmpty()){
        val (x,y, step) = needVisit.first().also { needVisit.remove(it) }
        result = maxOf(result, step.length)

        val xs = intArrayOf(-1,1,0,0)
        val ys = intArrayOf(0,0,-1,1)

        for(i in 0 until 4){
            val nextX = x + xs[i]
            val nextY = y + ys[i]

            if(nextX in board.indices && nextY in 0 until  board[0].length ){
                if(board[nextX][nextY] !in step)
                    needVisit.add(Triple(nextX, nextY, step + board[nextX][nextY]))
            }

        }
    }
    return result
}