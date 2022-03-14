package thisIsCodingTest

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*

// 이코테 BFS/DFS - 특정 거리의 도시 찾기
fun findCity(n: Int, path: MutableList<IntArray>, k: Int, x: Int): IntArray {
    val g = mutableMapOf<Int, MutableList<Int>>()
    (1..n).forEach {
        g[it] = mutableListOf()
    }

    path.forEach {
        val (a, b) = it
        g[a]?.add(b)
    }

    val distances = IntArray(n + 1) { Int.MAX_VALUE }
    distances[x] = 0
    val needVisit = PriorityQueue<IntArray>(compareBy { it[1] })
    needVisit.add(intArrayOf(x, 0))

    while (needVisit.isNotEmpty()) {
        val (curN, curD) = needVisit.poll()

        if (distances[curN] < curD) continue

        g[curN]?.forEach { nextN ->
            if (distances[nextN] > curD + 1) {
                distances[nextN] = curD + 1
                needVisit.add(intArrayOf(nextN, curD + 1))
            }
        }
    }

    val cities = mutableListOf<Int>()
    distances.forEachIndexed { index, i ->
        if (i == k) cities.add(index)
    }

    return if (cities.isNotEmpty()) cities.toIntArray() else intArrayOf(-1)
}

fun main() {
    with(BufferedReader(InputStreamReader(System.`in`))) {
        val bw = BufferedWriter(OutputStreamWriter(System.out))
        val (n, m, k, x) = readLine().split(" ").map { it.toInt() }

        val path = mutableListOf<IntArray>()

        repeat((0 until m).count()) {
            path.add(readLine().split(" ").map { it.toInt() }.toIntArray())
        }

        findCity(n,path,k,x).forEach {
            bw.write("$it\n")
            bw.flush()
        }
        bw.close()
    }
}