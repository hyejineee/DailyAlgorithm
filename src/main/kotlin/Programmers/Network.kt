package Programmers

import java.util.*

fun network(n: Int, computers: Array<IntArray>): Int {

    val visited = BooleanArray(n) { false }

    val network = mutableMapOf<Int, MutableList<Int>>()

    computers.forEachIndexed { i, v ->
        for (j in i + 1 until v.size) {
            if (computers[i][j] == 1) {
                network[i]?.add(j)?: run { network[i] = mutableListOf(j) }
            }
        }
    }

    var count = 0

    for (i in 0 until n) {
        if (visited[i]) continue

        val needVisit = LinkedList<Int>()
        needVisit.add(i)

        count ++

        while (needVisit.isNotEmpty()) {
            val pop = needVisit.pop()
            visited[pop] = true

            network[pop]?.forEach {
                needVisit.add(it)
            }
        }
    }

    return count
}