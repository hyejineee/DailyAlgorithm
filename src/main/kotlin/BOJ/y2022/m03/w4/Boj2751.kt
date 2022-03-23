package BOJ

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import kotlin.math.abs

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val nArr = Array<Int?>(1000001) { null }
    val pArr = Array<Int?>(1000001) { null }

    for (i in 0 until readLine().toInt()) {
        val n = readLine().toInt()
        if (n < 0) nArr[abs(n)] = n else pArr[n] = n
    }

    nArr.reversed().plus(pArr).filterNotNull().forEach { bw.write("$it\n") }

    bw.flush()
    bw.close()
}

