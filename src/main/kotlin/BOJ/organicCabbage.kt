package BOJ

import Programmers.result
import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*

fun main() {
    with(BufferedReader(InputStreamReader(System.`in`))) {
        val bw = BufferedWriter(OutputStreamWriter(System.out))

        val tc = readLine().toInt()

        (1..tc).forEach {
            val (m, n, k) = readLine().split(" ").map { it.toInt() }

            val farm = MutableList(n) {
                MutableList(m) { false }
            }

            val cabbagePositions = mutableListOf<Pair<Int, Int>>()

            (1..k).forEach {
                val (x, y) = readLine().split(" ").map { it.toInt() }
                cabbagePositions.add(Pair(y, x))
            }

            var earthWormCount = 0

            for (i in 0 until n) {
                for (j in 0 until m) {
                    if (farm[i][j]) continue

                    if (Pair(i, j) in cabbagePositions)
                        earthWormCount += bfs(i, j, farm, cabbagePositions)
                }
            }
            println(earthWormCount)

        }

        bw.flush()
        bw.close()
    }
}

private fun bfs(
    startY: Int,
    startX: Int,
    farm: MutableList<MutableList<Boolean>>,
    cabbagePositions: MutableList<Pair<Int, Int>>
): Int {
    val needVisit = LinkedList<Pair<Int, Int>>()
    val visited = LinkedList<Pair<Int, Int>>()

    needVisit.add(Pair(startY, startX))

    while (needVisit.isNotEmpty()) {
        val pop = needVisit.poll()


        if (pop in cabbagePositions && !farm[pop.first][pop.second] && pop !in visited) {
            farm[pop.first][pop.second] = true
            visited.add(pop)

            val nextPosition = listOf(
                Pair(pop.first - 1, pop.second),
                Pair(pop.first + 1, pop.second),
                Pair(pop.first, pop.second - 1),
                Pair(pop.first, pop.second + 1),
            ).forEach {
                if(it.first < farm.size && it.second < farm[0].size)
                    needVisit.add(it)
            }
        }
    }

    return if (visited.size > 0) 1 else 0
}