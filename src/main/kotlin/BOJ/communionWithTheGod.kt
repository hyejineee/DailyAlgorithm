package BOJ


import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*
import kotlin.math.sqrt

fun main() {

    with(BufferedReader(InputStreamReader(System.`in`))) {
        val (n,m) = readLine().split(" ").map { it.toInt() }

        val gods = mutableMapOf<Int, List<Int>>()
        val parent = mutableMapOf<Int, Int>()
        val rank = mutableMapOf<Int, Int>()
        val edges = mutableListOf<Triple<Double, Int,Int>>()

        (1..n).forEach { index ->
            val (x,y) = readLine().split(" ").map { it.toInt() }
            gods[index] = listOf(x,y)
            parent[index] = index
            rank[index] = 0
        }

        for(i in 1..n){
            for(j in i+1..n){
                val a = gods[i]!!
                val b = gods[j]!!
                val c = getDistance(a,b)

                edges.add(Triple(c, i, j))
            }
        }

        (1..m).forEach {
            val (n1, n2) = readLine().split(" ").map { it.toInt() }
            if(find(n1,parent) != find(n2,parent)){
                union(n1, n2, parent, rank)
            }
        }

        val sorted = edges.sortedBy { it.first }

        var coast = 0.0
        sorted?.forEach {  (c,a,b) ->
            if(find(a,parent) != find(b,parent)){
                union(a,b,parent, rank)
                coast +=c
            }
        }

        println("%.2f".format(coast))



    }
}
private fun find(node:Int, parent:MutableMap<Int,Int>): Int {
    if(parent[node] != node){
        parent[node] = find(parent[node]!!, parent)
    }
    return parent[node]!!
}

private fun union(n1:Int, n2:Int, parent: MutableMap<Int, Int>, rank :MutableMap<Int,Int>){
    val p1 = find(n1, parent)
    val p2 = find(n2, parent)

    if(rank[p1]!! < rank[p2]!!){
        parent[p1] = p2
    }else if(rank[p1]!! > rank[p2]!!){
        parent[p2] = p1
    }else{
        rank[p2] = rank[p2]?.plus(1)?:0
        parent[p1] = p2
    }
}

private fun getDistance(n1:List<Int>, n2:List<Int>): Double {
    val a:Long = (n1.first() - n2.first()).toLong()
    val b:Long = (n1.last() - n2.last()).toLong()
    return sqrt(((a*a)+(b*b)).toDouble())
}


