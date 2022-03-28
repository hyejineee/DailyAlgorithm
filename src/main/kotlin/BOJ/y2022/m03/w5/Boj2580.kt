package BOJ.y2022.m03.w5


import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val map = Array(9) {
        readLine().split(" ").map { it.toInt() }.toIntArray()
    }

    val empties = mutableListOf<IntArray>()

    for (i in 0 until 9) {
        for (j in 0 until 9) {
            if (map[i][j] == 0) empties.add(intArrayOf(i, j))
        }
    }

    dfs(0, map, empties)


}

private fun dfs(index: Int, map: Array<IntArray>, empties: MutableList<IntArray>) {
    if (index == empties.size) {
        map.forEach { println(it.joinToString(" ")) }
        System.exit(0)
        return
    }

    for (i in 1..9) {
        val (x, y) = empties[index]
        if (checkRow(x, i, map) && checkCol(y, i, map) && checkBox(x, y, i, map)) {
            map[x][y] = i
            dfs(index + 1, map, empties)
            map[x][y] = 0
        }
    }
}

private fun checkCol(y: Int, num: Int, map: Array<IntArray>): Boolean {
    for (i in 0 until 9) {
        if (map[i][y] == num) return false
    }
    return true
}

private fun checkRow(x: Int, num: Int, map: Array<IntArray>): Boolean {
    for (i in 0 until 9) {
        if (map[x][i] == num) return false
    }
    return true
}

private fun checkBox(x: Int, y: Int, num: Int, map: Array<IntArray>): Boolean {
    val sx = (x / 3) * 3
    val sy = (y / 3) * 3

    for (i in 0 until 3) {
        for (j in 0 until 3) {
            if (num == map[sx + i][sy + j]) return false
        }
    }

    return true
}
