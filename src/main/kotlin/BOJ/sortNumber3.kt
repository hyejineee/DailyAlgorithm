package BOJ


import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main() {
    with(BufferedReader(InputStreamReader(System.`in`))) {
        val bw = BufferedWriter(OutputStreamWriter(System.out))

        val a = MutableList(10001) { 0 }

        (0 until readLine().toInt()).forEach {
            a[readLine().toInt()]++
        }

        for (i in 0 until 10001) {
            if (a[i] == 0) continue
            repeat((0 until a[i]).count()) {
                bw.write("$i\n")
            }
        }

        bw.flush()
        bw.close()
    }
}