package BOJ


import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.roundToInt
import kotlin.math.sqrt

fun main() {

    with(BufferedReader(InputStreamReader(System.`in`))) {
        val (n, m) = readLine().split(" ").map { it.toInt() }

        val gods = mutableListOf<God>()
        val edges = mutableListOf<Triple<Double, God, God>>()
        val parent = mutableMapOf<Int, Int>()
        val rank = mutableMapOf<Int, Int>()

        (1..n).forEach { index ->
            val (x, y) = readLine().split(" ").map { it.toInt() }
            gods.add(God(index, x, y))
            parent[index] = index
            rank[index] = 0
        }

        for(i in 0 until n){
            for(j in i+1 until n){
                val a = gods[i]
                val b = gods[j]
                edges.add(Triple(getCoast(a,b), a, b))
            }
        }

        (1..m).forEach {
            val (a, b) = readLine().split(" ").map { it.toInt() }
            val g1 = gods.find { it.index == a }?:return
            val g2 = gods.find { it.index == b }?:return

            if(find(g1.index,parent) != find(g2.index, parent)){
                union(g1.index, g2.index, parent, rank)

            }
        }

        val sorted = edges.sortedBy { it.first }
        var coast = 0.0

        sorted.forEach {
            val (c, n1, n2) = it

            if(find(n1.index,parent) != find(n2.index,parent)){
                union(n1.index, n2.index, parent,rank)
                coast +=c
            }
        }


        println("%.2f".format(coast))
    }
}

private fun getCoast(a: God, b: God): Double {
    val v1 :Long= (a.x - b.x).toLong()
    val v2:Long = (a.y - b.y).toLong()

    return sqrt( ((v1*v1).toDouble() + (v2*v2)))
}

private data class God(val index: Int, val x: Int, val y: Int) {}

private fun find(node:Int, parent:MutableMap<Int,Int>): Int {
    if(parent[node] != node){
        parent[node] = find(parent[node]!!, parent)
    }
    return parent[node]!!
}

private fun union(node1:Int, node2:Int, parent: MutableMap<Int, Int>, rank:MutableMap<Int,Int>){
    val r1 = find(node1, parent)
    val r2 = find(node2, parent)

    if((rank[r1] ?: 0) > (rank[r2] ?: 0)){
        parent[r2] = r1
    }else if((rank[r1] ?: 0) < (rank[r2] ?: 0)){
        parent[r1] = r2
    }else{
        rank[r2] = rank[r2]?.plus(1)?:0
        parent[r1] = r2
    }
}