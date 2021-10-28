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
                bw.write(timePerPosition[pop].toString())
                break
            }

            for(next in listOf(pop+1, pop-1, pop*2)){
                if(next in 0 .. 100000){
                    if(timePerPosition[next]==0){
                        timePerPosition[next] = timePerPosition[pop] + 1
                        needVisit.add(next)
                    }
                }
            }
        }

        bw.flush()
        bw.close()

    }
}

