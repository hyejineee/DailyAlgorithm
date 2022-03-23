package BOJ

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import kotlin.math.abs

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val n = readLine().toCharArray().map { Character.getNumericValue(it) }
    bw.write(n.sortedDescending().joinToString(""))
    bw.flush()
    bw.close()
}

