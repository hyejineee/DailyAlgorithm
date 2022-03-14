package BOJ

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*

fun main() {
    with(BufferedReader(InputStreamReader(System.`in`))) {
        val bw = BufferedWriter(OutputStreamWriter(System.out))
        val (n, m, v) = readLine().split(" ").map { it.toInt() }

        val g = mutableMapOf<Int, MutableList<Int>>()

        (1 .. n).forEach {
            g[it] = mutableListOf()
        }

        (0 until m).forEach {
            val (v1, v2) = readLine().split(" ").map { it.toInt() }
            g[v1]?.add(v2)
            g[v2]?.add(v1)
        }

        (1 .. n).forEach {
            g[it]?.sort()
        }

        println(dfs(v,g).joinToString(" "))
        println(bfs(v,g).joinToString(" "))


        bw.flush()
        bw.close()
    }
}

private fun dfs(startNode : Int, g:MutableMap<Int, MutableList<Int>>): LinkedList<Int> {
    val visited = LinkedList<Int>()
    val needVisited = Stack<Int>()

    needVisited.push(startNode)

    while (needVisited.isNotEmpty()){
        val pop = needVisited.pop()

        if(pop !in visited){
            visited.add(pop)

            g[pop]?.reversed()?.forEach {
                if(it !in visited){
                    needVisited.push(it)
                }
            }
        }
    }
    return visited
}

private fun bfs(startNode: Int, g:MutableMap<Int, MutableList<Int>>): LinkedList<Int> {
    val visited = LinkedList<Int>()
    val needVisited = LinkedList<Int>()

    needVisited.push(startNode)

    while (needVisited.isNotEmpty()){
        val pop = needVisited.poll()

        if(pop !in visited){
            visited.add(pop)

            g[pop]?.forEach {
                if(it !in visited){
                    needVisited.add(it)
                }
            }
        }
    }
    return visited
}