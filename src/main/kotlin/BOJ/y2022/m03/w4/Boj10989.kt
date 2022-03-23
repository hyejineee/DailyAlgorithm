package BOJ

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import kotlin.math.abs

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val n = readLine().toInt()

    val arr = IntArray(10001){0}

    for (i in 0 until n){
        arr[readLine().toInt()]++
    }

    for (i in arr.indices){
        if(arr[i] == 0) continue
        repeat(arr[i]){bw.write("$i\n")}
    }

    bw.flush()
    bw.close()
}

