package BOJ

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main() {
    with(BufferedReader(InputStreamReader(System.`in`))) {
        val bw = BufferedWriter(OutputStreamWriter(System.out))

        val testCase = readLine().toInt()

        for (i in 0 until testCase) {
            val c = readLine().toInt()

            val network = (0 until c).map {
                readLine().split(" ")
            }

            val v = network.flatten().toSet()

            val parent = mutableMapOf<String, String>()
            val rank = mutableMapOf<String, Int>()

            v.forEach {
                parent[it] = it
                rank[it] = 1
            }

            network.forEach {
                union(it[0], it[1], parent, rank)
                bw.write("${rank[find(it.first(), parent)]!!}\n")
            }
        }
        bw.flush()
        bw.close()
    }
}

fun friendNetwork(network: List<List<String>>): List<Int> {

    val v = network.flatten().toSet()

    val parent = mutableMapOf<String, String>()
    val rank = mutableMapOf<String, Int>()

    v.forEach {
        parent[it] = it
        rank[it] = 1
    }

    network.forEach {

        union(it[0], it[1], parent, rank)
        println(rank[find(it.first(), parent)])
    }
    return listOf()
}

fun find(node: String, parent: MutableMap<String, String>): String {
    if (parent[node] != node) {
        parent[node] = find(parent[node] ?: node, parent)
    }
    return parent[node] ?: node
}

fun union(node1: String, node2: String, parent: MutableMap<String, String>, rank: MutableMap<String, Int>) {
    val p1 = find(node1, parent)
    val p2 = find(node2, parent)

    if (p1 != p2) {
        parent[p2] = p1
        rank[p1] = rank[p1]!!.plus(rank[p2]!!)
    }

}


