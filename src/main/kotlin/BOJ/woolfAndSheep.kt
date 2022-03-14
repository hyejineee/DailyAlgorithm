package BOJ

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*
import kotlin.system.exitProcess


fun main() {

    with(BufferedReader(InputStreamReader(System.`in`))) {
        val (r, c) = readLine().split(" ").map { it.toInt() }

        val ranch = MutableList(r) {
            readLine().toCharArray().toMutableList()
        }

        val visited = MutableList(r) {
            MutableList(c) { false }
        }

        for (i in 0 until r) {
            for (j in 0 until c) {
                if (ranch[i][j] == 'W') {
                    if(!dfs(ranch, listOf(i, j), r, c, visited)){
                        println("0")
                        exitProcess(0)
                    }
                }
            }
        }

        println("1")
        ranch.forEach {
            println(it.joinToString(""))
        }
    }
}

private fun dfs(ranch: MutableList<MutableList<Char>>, start: List<Int>, r: Int, c: Int, visited:MutableList<MutableList<Boolean>>): Boolean {
    val needVisit = Stack<List<Int>>()
    needVisit.add(start)

    val dx = listOf(-1, 1, 0, 0)
    val dy = listOf(0, 0, 1, -1)

    while (needVisit.isNotEmpty()) {
        val (x, y) = needVisit.pop()

        visited[x][y] = true

        for (i in dx.indices) {
            val nextX = x + dx[i]
            val nextY = y + dy[i]

            if (nextX !in 0 until r || (nextY !in 0 until c)) continue

            if (ranch[nextX][nextY] != 'S' && !visited[nextX][nextY]) {
                needVisit.add(listOf(nextX, nextY))
            } else if (ranch[nextX][nextY] == 'S' && ranch[x][y] == '.') {
                ranch[x][y] = 'D'
            } else if(ranch[nextX][nextY] == 'S' && ranch[x][y] == 'W'){
                return false
            }
        }
    }

    return true
}