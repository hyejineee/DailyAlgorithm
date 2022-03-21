package thisIsCodingTest

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val (n,m) = readLine().split(" ").map { it.toInt() }
    val map = Array(n){ readLine().split(" ").map { it.toInt() }.toIntArray()}
    val result = laboratory(n,m, map)
    println(result)
}

fun laboratory(n: Int, m: Int, map: Array<IntArray>): Int {
    val viruses = mutableListOf<IntArray>()
    var answer = 0

    for (i in 0 until n) {
        for (j in 0 until m) {
            if (map[i][j] == 2) viruses.add(intArrayOf(i, j))
        }
    }

    for (i in 0 until n * m) {
        val (x1, y1) = i / m to i % m
        if (map[x1][y1] != 0) continue

        for (j in i + 1 until n * m) {
            val (x2, y2) = j / m to j % m
            if (map[x2][y2] != 0) continue

            for (k in j + 1 until n * m) {
                val (x3, y3) = k / m to k % m
                if (map[x3][y3] != 0) continue

                map[x1][y1] = 1
                map[x2][y2] = 1
                map[x3][y3] = 1

                val tempMap = Array(n) { r -> IntArray(m) { c -> map[r][c] } }
                val count = spread(tempMap, viruses, n, m)
                answer = maxOf(answer, count)

                map[x1][y1] = 0
                map[x2][y2] = 0
                map[x3][y3] = 0

            }
        }
    }

    return answer
}


private fun spread(map: Array<IntArray>, vs: MutableList<IntArray>, n: Int, m: Int): Int {

    val dx = intArrayOf(0, 0, 1, -1)
    val dy = intArrayOf(1, -1, 0, 0)

    val visited = Array(n) { i -> BooleanArray(m) { j -> map[i][j] != 0 } }
    val needVisit = LinkedList<IntArray>()
    vs.forEach { needVisit.add(it) }

    while (needVisit.isNotEmpty()) {
        val (x, y) = needVisit.poll()
        visited[x][y] = true

        for (i in 0 until 4) {
            val nx = x + dx[i]
            val ny = y + dy[i]

            if ((nx in 0 until n && ny in 0 until m).not()) continue

            if (map[nx][ny] == 0 && visited[nx][ny].not()) {
                needVisit.add(intArrayOf(nx, ny))
                map[nx][ny] = 2
            }
        }
    }

    return map.flatMap { it.toList() }.count { it == 0 }
}