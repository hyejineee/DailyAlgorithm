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

        val nodes = mutableMapOf<Int, MutableList<Int>>()
        val inDegree = MutableList(n+1){0}

        val heap = PriorityQueue<Int>()

        (1 .. n).forEach {
            nodes[it] = mutableListOf()
        }

        (0 until m).forEach {
            val (a,b) = readLine().split(" ").map { it.toInt() }
            nodes[a]?.add(b)
            inDegree[b]+=1
        }

        for( i in 1 until inDegree.size){
            if(inDegree[i] ==0) heap.add(i)
        }

        val result = mutableListOf<Int>()

        while (heap.isNotEmpty()){

            val pop = heap.poll()
            result.add(pop)

            nodes[pop]?.forEach {
                inDegree[it] -=1
                if(inDegree[it] ==0){
                    heap.add(it)
                }
            }
        }

        bw.write("${result.joinToString(" ")}")


        bw.flush()
        bw.close()
    }
}

