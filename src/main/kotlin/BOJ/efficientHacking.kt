package BOJ

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*

fun main() {
    with(BufferedReader(InputStreamReader(System.`in`))) {

        val bw = BufferedWriter(OutputStreamWriter(System.out))

        val (n, m) = readLine().split(" ").map { it.toInt() }
        val g = mutableMapOf<Int, MutableList<Int>>()
        (1..n).forEach {
            g[it] = mutableListOf()
        }

        (1..m).forEach {
            val (n1, n2) = readLine().split(" ").map { it.toInt() }
            g[n2]?.add(n1)
        }

        var result = mutableListOf<Int>()
        var max = -1

        for (i in 1..n) {
            val c = bfs(i, g)

            if (max <= c) {
                max = c
                result.add(i)
            }
        }

        for (i in result) {
            print("$i ")
        }
        bw.flush()
        bw.close()
    }
}

private fun bfs(startNode: Int, g: MutableMap<Int, MutableList<Int>>): Int {
    val needVisit = LinkedList<Int>()
    val visited = MutableList(g.size + 1) { false }
    var visitedCount = 1

    visited[startNode] = true
    needVisit.add(startNode)

    while (needVisit.isNotEmpty()) {
        val pop = needVisit.pollFirst()

        g[pop]?.forEach {
            if(!visited[it]){
                needVisit.add(it)
                visited[it] = true
                visitedCount ++
            }
        }
    }

    return visitedCount
}