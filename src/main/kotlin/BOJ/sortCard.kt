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
            list.add(readLine().toInt())
        }


        var result =0
        while (list.size > 1){
            val b1 = if(list.isNotEmpty()) list.poll() else 0
            val b2 = if(list.isNotEmpty()) list.poll() else 0

            result += b1 + b2
            list.add(b1+b2)
        }

        bw.write("${result}")

        bw.flush()
        bw.close()
    }
}

