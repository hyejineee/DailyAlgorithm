package BOJ

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter


fun main() {

    with(BufferedReader(InputStreamReader(System.`in`))) {
        val bw = BufferedWriter(OutputStreamWriter(System.out))
        val n = readLine().toInt()
        val arr = readLine().split(" ").map { it.toInt() }

        val m = readLine().toInt()
        val findNumber = readLine().split(" ").map { it.toInt() }

        findNumber.forEach { n ->
            bw.write("${if(n in arr) 1 else 0}\n")
        }
        bw.flush()
        bw.close()
    }
}