package thisIsCodingTest

import Programmers.convert
import java.util.*

class BFSDFS {

    fun freezeDrinks(board: Array<IntArray>): Int {
        val n = board.size
        val m = board[0].size

        val available = Array(n) { i ->
            BooleanArray(m) { j ->
                board[i][j] != 0
            }
        }

        var count = 0
        for (i in 0 until n) {
            for (j in 0 until m) {
                if(dfs(i,j,available)){
                    count++
                }
            }
        }
        return count
    }

    private fun dfs(i: Int, j: Int, available: Array<BooleanArray>): Boolean {
        val n = available.size
        val m = available[0].size

        if (((i in 0 until n ) && (j in 0 until m)).not()) return false

        if (available[i][j].not()) {
            available[i][j] = true

            dfs(i - 1, j, available)
            dfs(i + 1, j , available)
            dfs(i, j - 1, available)
            dfs(i, j+1, available)
            return true
        }
        return false
    }

    fun mazeEscape(n:Int, m:Int, maze:Array<IntArray>):Int{

        val dx = intArrayOf(1,0,-1,0)
        val dy = intArrayOf(0,1,0,-1)

        val needVisit = Stack<IntArray>()
        needVisit.add(intArrayOf(0,0,1))

        while (needVisit.isNotEmpty()){
            maze.forEach {
                println(it.toList())
            }
            println("=======")
            val (y,x, count) = needVisit.pop()

            for(i in 0..3) {
                val nx = x + dx[i]
                val ny = y + dy[i]

                if((ny in 0 until n && nx in 0 until m).not()) continue
                if(maze[ny][nx] == 0 ) continue

                if(maze[ny][nx] ==1){
                    maze[ny][nx] = count+1
                    needVisit.add(intArrayOf(ny,nx, count+1))
                }
            }
        }

        return maze[n-1][m-1]
    }
}