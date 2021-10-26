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

        val arr = MutableList(100001){0}

        val needVisit = LinkedList<Int>()

        needVisit.push(n)

        while (needVisit.isNotEmpty()){
            val pop = needVisit.pollFirst()

            if(pop == k){
                println(arr[pop])
                break
            }

            for (i in listOf(pop+1, pop-1, pop*2)){
                if(i in 0 until 100001){
                    if(arr[i] == 0){
                        arr[i] = arr[pop] + 1
                        needVisit.add(i)
                    }
                }
            }
        }


        bw.flush()
        bw.close()
    }
}
