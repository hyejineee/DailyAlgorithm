package BOJ

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*

fun main() {
    with(BufferedReader(InputStreamReader(System.`in`))) {
        val bw = BufferedWriter(OutputStreamWriter(System.out))

        val n = readLine().toInt()

        var list = PriorityQueue<Int>()

        (0 until n).forEach{
            val oper = readLine().toInt()

            when(oper){
                0-> {
                    if(list.isEmpty()) {
                        bw.write("0\n")
                    }else{
                        bw.write("${list.poll()}\n")
                    }
                }
                else ->{
                    list.add(oper)
                }
            }
        }

        bw.flush()
        bw.close()
    }
}

