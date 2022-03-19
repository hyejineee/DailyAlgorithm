package Programmers

import java.util.*

fun delivery(N: Int, road: Array<IntArray>, k: Int): Int {

    val g = mutableMapOf<Int, MutableList<IntArray>>().apply {
        for (i in 1..N){
            this[i] = mutableListOf()
        }
    }

    road.forEach {
        val (a,b,c) = it
        g[a]?.add(intArrayOf(b,c))
        g[b]?.add(intArrayOf(a,c))
    }

    val ds = IntArray(N+1){10000000}
    val q = PriorityQueue<IntArray>(compareBy { it[1] })

    ds[1] = 0
    q.add(intArrayOf(1,0))

    while (q.isNotEmpty()){
        val (cn, cd) = q.poll()

        g[cn]?.forEach { (n,d)->
            val newD = cd + d
            if(ds[n]> newD){
                q.add(intArrayOf(n, newD))
                ds[n] = newD
            }
        }
    }

    return ds.count { it <=k }
}
