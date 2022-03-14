package thisIsCodingTest

import Ds.union
import Programmers.result
import java.util.*
import kotlin.math.max
import kotlin.math.min

class Graph {
    fun teamFormation(n: Int, ops: Array<IntArray>): Array<String> {

        val parents = IntArray(n + 1) { it }
        val result = mutableListOf<String>()

        ops.forEach {
            val (op, n1, n2) = it

            if (op == 0) {
                if (findParents(n1, parents) != findParents(n2, parents))
                    unionParents(n1, n2, parents)
            }

            if (op == 1) {
                result.add(if (findParents(n1, parents) == findParents(n2, parents)) "YES" else "NO")
            }
        }

        return result.toTypedArray()
    }

    private fun findParents(node: Int, parents: IntArray): Int {
        if (parents[node] != node) {
            parents[node] = findParents(parents[node], parents)
        }
        return parents[node]
    }

    private fun unionParents(n1: Int, n2: Int, parents: IntArray) {
        val p1 = findParents(n1, parents)
        val p2 = findParents(n2, parents)

        if (p1 > p2) {
            parents[p1] = p2
        } else {
            parents[p2] = p1
        }
    }

    fun cityDivisionPlan(n: Int, path: Array<IntArray>): Int {

        val parents = IntArray(n + 1) { it }

        val sorted = path.sortedBy { it[2] }

        var totalCost = 0
        var last = 0

        sorted.forEach {
            val (n1, n2, c) = it

            if (findParents(n1, parents) != findParents(n2, parents)) {
                unionParents(n1, n2, parents)
                totalCost += c
                last = c
            }
        }

        return totalCost - last
    }

    fun curriculum(subjects: Array<IntArray>): Int {
        val indegree = IntArray(subjects.size + 1) { 0 }
        val time = IntArray(subjects.size + 1) { 0 }
        val g = mutableMapOf<Int, MutableList<Int>>()

        for(i in 1 .. subjects.size){
            time[i] = subjects[i-1][0]
            for (j in 1 until subjects[i-1].size) {
                indegree[i] += 1
                g[j]?.add(i) ?: kotlin.run { g[j] = mutableListOf(i) }
            }
        }


        println(g)
        println(indegree.toList())

        val result = topologySort(indegree, g, time)

        println(result.toList())
        return 0
    }

    private fun topologySort(indegree: IntArray, g: MutableMap<Int, MutableList<Int>>, time: IntArray): IntArray {
        val result = time.copyOf()
        val q = LinkedList<Int>()

        for(i in 1 until indegree.size){
            if(indegree[i] ==0){
                q.add(i)
            }
        }


        while (q.isNotEmpty()) {
            val now = q.poll()

            g[now]?.forEach {
                result[it] = maxOf(result[it], result[now] + time[it])

                indegree[it] -= 1

                if (indegree[it] == 0) {
                    q.add(it)
                }
            }
        }
        return result
    }

}