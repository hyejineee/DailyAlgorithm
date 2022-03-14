package BOJ

import Programmers.result
import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*

fun main() {
    with(BufferedReader(InputStreamReader(System.`in`))) {
        val bw = BufferedWriter(OutputStreamWriter(System.out))

        val nodeCount = readLine().toInt()
        val c = readLine().toInt()

        val g = mutableMapOf<Int, MutableList<Int>>()

        (1..nodeCount).forEach {
            g[it] = mutableListOf()
        }

        (1..c).forEach {
            val (n1, n2) = readLine().split(" ").map { it.toInt() }
            g[n1]?.add(n2)
            g[n2]?.add(n1)
        }

        val needVisit = LinkedList<Int>()
        val visited = LinkedList<Int>()

        needVisit.add(1)

        while (needVisit.isNotEmpty()){
            val pop = needVisit.poll()

            if(pop !in visited){
                visited.add(pop)
                g[pop]?.forEach {
                    if(it !in visited){
                        needVisit.add(it)
                    }
                }
            }
        }

        println(visited.size -1)

        bw.flush()
        bw.close()
    }
}