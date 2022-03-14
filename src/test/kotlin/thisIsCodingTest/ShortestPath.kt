package thisIsCodingTest

import java.util.*
import kotlin.math.min

class ShortestPath {
    fun futureCity(n: Int, m: Int, path: Array<IntArray>, x: Int, k: Int): Int {
        val dp = Array(n + 1) { i ->
            IntArray(n + 1) { j ->
                if(i ==j ) 0 else 1000
            }
        }


        path.forEach {
            val (n1, n2) = it
            dp[n1][n2] = 1
            dp[n2][n1] = 1
        }


        for (k in 1..n) {
            for (i in 1..n) {
                for (j in 1..n) {
                    dp[i][j] = min(dp[i][j], dp[i][k] + dp[k][j])
                }
            }
        }

        val distance = dp[1][k] + dp[k][x]
        return if(distance > 1000) -1 else distance
    }

    fun telegram(n:Int, path:Array<IntArray>,c:Int):String{

        val distances = IntArray(n+1){10001}
        val p = PriorityQueue<IntArray>(kotlin.Comparator { o1, o2 ->o1[1] - o2[1] })
        val g = mutableMapOf<Int, MutableList<IntArray>>()

        path.forEach {
            val (n1, n2, cost) = it
            g[n1]?.add(intArrayOf(n2, cost))?: kotlin.run {  g[n1] = mutableListOf(intArrayOf(n2, cost))}
        }

        distances[c] = 0
        p.add(intArrayOf(c, distances[c]))

        while (p.isNotEmpty()){
            val (currentNode, currentDistance) = p.poll()

            if(distances[currentNode] < currentDistance) continue

            g[currentNode]?.forEach {
                val (nextNode, cost) = it
                val newDistance = currentDistance + cost

                if(distances[nextNode] > newDistance){
                    distances[nextNode] = newDistance
                    p.add(intArrayOf(nextNode, newDistance))
                }
            }
        }

        val count = distances.filterIndexed { index, i -> index!=c && i in 0 until  10001 }
        val time = count.maxBy { it }?:0
        return "${count.size} $time"
    }

}