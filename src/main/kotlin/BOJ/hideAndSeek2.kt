package BOJ

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*

fun main() {
    with(BufferedReader(InputStreamReader(System.`in`))) {
        val bw = BufferedWriter(OutputStreamWriter(System.out))

        val (n, k) = readLine().split(" ").map { it.toInt() }
        val timePerPosition = MutableList(100001){0}

        val needVisit = LinkedList<Int>()
        needVisit.add(n)

        while (needVisit.isNotEmpty()){
            val pop = needVisit.pollFirst()

            if(pop == k){
                break
            }

            val nextPositions = listOf(pop +1, pop-1, pop*2)
            for(nextPosition in nextPositions){
                if(nextPosition in 0 until 100001){
                    if(timePerPosition[nextPosition] == 0){
                        timePerPosition[nextPosition] = timePerPosition[pop] + 1
                        needVisit.add(nextPosition)
                    }
                }
            }
        }

        println(timePerPosition[k])


        bw.flush()
        bw.close()
    }
}
