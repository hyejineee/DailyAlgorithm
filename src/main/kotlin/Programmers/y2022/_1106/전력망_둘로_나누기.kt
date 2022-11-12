package Programmers.y2022._1106

import kotlin.math.*

fun 전력망_둘로_나누기(n: Int, wires: Array<IntArray>): Int {
    val graph = mutableMapOf<Int, MutableList<Int>>()

    wires.forEach {
        val (n1, n2) = it
        graph[n1]?.add(n2) ?: run {
            graph[n1] = mutableListOf(n2)
        }

        graph[n2]?.add(n1) ?: run {
            graph[n2] = mutableListOf(n1)
        }
    }

    var min = n
    for(i in 1..n){
        val visited = BooleanArray(n+1){false}
        val parent = mutableMapOf<Int, Int>()

        for(p in 1..n){
            parent[p] = p
        }

        findParent(graph, visited, parent, i)

        for(j in 1..n){
            if(i == j) continue
            val child = findChild(parent, j,i)
            min = min(min, abs(child +1 - (n -(child +1))))
        }
    }
    return min
}

fun findParent(
    graph: MutableMap<Int, MutableList<Int>>,
    visited: BooleanArray,
    parent: MutableMap<Int, Int>,
    node: Int
) {
    visited[node] = true

    for (n in graph[node]!!) {
        if (visited[n]) continue
        parent[n] = node
        findParent(graph, visited, parent, n)
    }
}

fun findChild(tree: MutableMap<Int, Int>, node: Int, root: Int): Int {
    if (node == root) return tree.size - 1

    var count = 0

    fun find (n : Int){
        val child = tree.filterValues { it == n }
        if(child.isEmpty()) return
        if(n == root) return

        child.forEach { k, v ->
            count++
            find(k)
        }
    }

    find((node))
    return count
}